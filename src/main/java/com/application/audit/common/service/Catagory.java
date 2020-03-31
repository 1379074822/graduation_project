package com.application.audit.common.service;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

/**
 * @description:
 * @author:
 * @time: 2020/3/30 14:33
 */
@Data
public class Catagory extends BaseRowModel {
    @ExcelProperty(value = "用户名", index = 0)
    private String user_name;
    @ExcelProperty(value = "电话号码", index = 1)
    private String phone_num;
    @ExcelProperty(value = "年龄", index = 2)
    private Integer age;
    @ExcelProperty(value = "性别", index = 3)
    private String gender;
    @ExcelProperty(value = "专业", index = 4)
    private String profession;
    @ExcelProperty(value = "职称", index = 5)
    private String level;
    @ExcelProperty(value = "研究成果", index = 6)
    private String research_result;
    @ExcelProperty(value = "工作业绩", index = 6)
    private String work_perform;


}
