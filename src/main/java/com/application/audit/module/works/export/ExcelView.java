package com.application.audit.module.works.export;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.StringUtil;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Spring Web - XLS视图
 */
public class ExcelView extends AbstractXlsView {

    /** 字符集 */
    private static final Charset UTF8 = StringUtil.UTF8;
    /** 文件名 */
    public static final String FILENAME_KEY = "filename";
    /** 属性 */
    public static final String PROPERTY_KEY = "properties";
    /** 内容 */
    public static final String CONTENT_KEY = "contents";

    @Override
    protected void buildExcelDocument(@SuppressWarnings("NullableProblems") Map<String, Object> model, @SuppressWarnings("NullableProblems") Workbook workbook, @SuppressWarnings("NullableProblems") HttpServletRequest request, @SuppressWarnings("NullableProblems") HttpServletResponse response) throws UnsupportedEncodingException {
        //获取文件名
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String filename = model.get(FILENAME_KEY) + "-" + dateFormat.format(new Date()) + ".xls";
        //获取属性
        LinkedHashMap<String, String> properties = (LinkedHashMap<String, String>) model.get(PROPERTY_KEY);
        //获取内容
        ArrayList<Map<String, Object>> contents = (ArrayList<Map<String, Object>>) model.get(CONTENT_KEY);

        // 标题样式-粗体
        CellStyle boldStyle = workbook.createCellStyle();
        Font fontStyle = workbook.createFont();
        fontStyle.setBold(true);
        boldStyle.setFont(fontStyle);
        // 写入excel
        Sheet sheet = workbook.createSheet();
        int rowNumber = 0;
        //写入标题
        if (MapUtils.isNotEmpty(properties)) {
            Row headerRow = sheet.createRow(rowNumber++);
            int cellNumber = 0;
            for (Map.Entry<String, String> property : properties.entrySet()) {
                Cell cell = headerRow.createCell(cellNumber++);
                cell.setCellStyle(boldStyle);
                cell.setCellValue(property != null ? property.getValue() : null);
                // 列宽自适应
                sheet.autoSizeColumn(cell.getColumnIndex(), true);
            }
        }
        // 写入内容
        if (CollectionUtils.isNotEmpty(contents)) {
            for (Map<String, Object> content : contents) {
                Row dataRow = sheet.createRow(rowNumber++);
                int cellNumber = 0;
                for (Map.Entry<String, String> property : properties.entrySet()) {
                    Cell cell = dataRow.createCell(cellNumber++);
                    cell.setCellValue(content != null && property != null ? String.valueOf(content.get(property.getKey())) : null);
                }
            }
        }
        //文件名编码
        String name;
        String userAgent = request.getHeader("user-agent").toLowerCase();
        if (userAgent.contains("msie") || userAgent.contains("like gecko")) {
            // IE
            name = URLEncoder.encode(filename, UTF8.name());
        } else {
            // 非IE
            name = new String(filename.getBytes(UTF8.name()), "ISO-8859-1");
        }
        // 设置header 下载
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, ContentDisposition.builder("attachment").filename(name).build().toString());
        // 字符集
        response.setCharacterEncoding(UTF8.name());
    }
}

