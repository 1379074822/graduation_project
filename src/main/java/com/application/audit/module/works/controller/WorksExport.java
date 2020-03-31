package com.application.audit.module.works.controller;

import com.application.audit.common.enums.AuditProfessionEnum;
import com.application.audit.common.enums.GenderEnum;
import com.application.audit.common.enums.ProfessionEnum;
import com.application.audit.common.enums.StatusEnum;
import com.application.audit.module.user.entity.UserBO;
import com.application.audit.module.user.service.UserService;
import com.application.audit.module.works.entity.WorksBO;
import com.application.audit.module.works.entity.WorksListBO;
import com.application.audit.module.works.export.ExcelView;
import com.application.audit.module.works.service.WorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author:
 * @time: 2020/3/18 12:00
 */
@Controller
@RequestMapping("/export")
public class WorksExport {

    @Autowired
    private WorksService worksService;
    @Autowired
    private UserService userService;


    @RequestMapping("/excel")
    @SuppressWarnings("Duplicates")
    public ModelAndView exprot( WorksBO worksBO){
        //属性
        Map<String, String> properties = new LinkedHashMap<>(4);
        properties.put("id", "作品id");
        properties.put("worksName", "作品名称");
        properties.put("worksDesc", "作品介绍");
        properties.put("fileUrl", "作品访问路径");
        properties.put("score", "作品得分");
        properties.put("type", "类型");
        properties.put("createName", "作者");
        properties.put("createTime", "上传时间");
        properties.put("status", "状态");
        //内容
        List<Map<String, Object>> contents = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<WorksListBO> worksListBOS = worksService.allWithScoreSearch(worksBO);
        for (WorksListBO worksListBO : worksListBOS) {
            Map<String, Object> content = new HashMap<>(4);
            content.put("id", worksListBO.getId());
            content.put("worksName",worksListBO.getWorksName());
            content.put("worksDesc", worksListBO.getWorksDesc());
            content.put("fileUrl", worksListBO.getFileUrl());
            content.put("score",worksListBO.getScore());
            content.put("type", ProfessionEnum.getNameByIndex(worksListBO.getType()));
            content.put("createName", worksListBO.getCreateName());
            content.put("createTime", simpleDateFormat.format(worksListBO.getCreateTime()));
            content.put("status", StatusEnum.getNameByIndex(worksListBO.getStatus()));
            contents.add(content);
        }

        //模型
        Map<String, Object> model = new HashMap<>(3);
        model.put(ExcelView.FILENAME_KEY, "作品导出");
        model.put(ExcelView.PROPERTY_KEY, properties);
        model.put(ExcelView.CONTENT_KEY, contents);
        //返回视图
        return new ModelAndView(new ExcelView(), model);
    }



    @GetMapping("/getHigh")
    @SuppressWarnings("Duplicates")
    public ModelAndView getHigh( Integer batch){
        //属性
        Map<String, String> properties = new LinkedHashMap<>(4);
        properties.put("id", "作品id");
        properties.put("worksName", "作品名称");
        properties.put("worksDesc", "作品介绍");
        properties.put("fileUrl", "作品访问路径");
        properties.put("score", "票数");
        properties.put("type", "类型");
        properties.put("createName", "作者");
        properties.put("createTime", "上传时间");
        properties.put("status", "状态");
        //内容
        List<Map<String, Object>> contents = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<WorksListBO> list = worksService.getHighRate(batch);
        for (WorksListBO worksListBO : list) {
            Map<String, Object> content = new HashMap<>(4);
            content.put("id", worksListBO.getId());
            content.put("worksName",worksListBO.getWorksName());
            content.put("worksDesc", worksListBO.getWorksDesc());
            content.put("fileUrl", worksListBO.getFileUrl());
            content.put("score",worksListBO.getScore());
            content.put("type", ProfessionEnum.getNameByIndex(worksListBO.getType()));
            content.put("createName", worksListBO.getCreateName());
            content.put("createTime", simpleDateFormat.format(worksListBO.getCreateTime()));
            content.put("status", StatusEnum.getNameByIndex(worksListBO.getStatus()));
            contents.add(content);
        }

        //模型
        Map<String, Object> model = new HashMap<>(3);
        model.put(ExcelView.FILENAME_KEY, "作品导出");
        model.put(ExcelView.PROPERTY_KEY, properties);
        model.put(ExcelView.CONTENT_KEY, contents);
        //返回视图
        return new ModelAndView(new ExcelView(), model);
    }


    @RequestMapping("/userExcel")
    @SuppressWarnings("Duplicates")
    public ModelAndView userExcel( UserBO userBO){
        //属性
        Map<String, String> properties = new LinkedHashMap<>(4);
        properties.put("user_name", "用户名");
        properties.put("phone_num", "电话号码");
        properties.put("age", "年龄");
        properties.put("gender", "性别");
        properties.put("profession", "专业");
        properties.put("level", "职称");
        properties.put("research_result", "研究成果");
        properties.put("work_perform", "工作业绩");
        if(userBO.getIsTemplate().equals(1)){
            Map<String, Object> model = new HashMap<>(3);
            model.put(ExcelView.FILENAME_KEY, "评委导入模板");
            model.put(ExcelView.PROPERTY_KEY, properties);
            model.put(ExcelView.CONTENT_KEY, null);
            //返回视图
            return new ModelAndView(new ExcelView(), model);
        }
        //内容
        List<Map<String, Object>> contents = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<UserBO> userListSearch = userService.getUserListSearch(userBO);
        for (UserBO userBO1 : userListSearch) {
            Map<String, Object> content = new HashMap<>(4);
            content.put("user_name", userBO1.getUserName());
            content.put("phone_num",userBO1.getPhoneNum());
            content.put("age", userBO1.getAge());
            content.put("gender", GenderEnum.getNameByIndex(userBO1.getGender()));
            content.put("profession", AuditProfessionEnum.getNameByIndex(userBO1.getProfession()));
            content.put("level", userBO1.getLevel());
            content.put("research_result", userBO1.getResearchResult());
            content.put("work_perform", userBO1.getWorkPerform());
            contents.add(content);
        }
        //模型
        Map<String, Object> model = new HashMap<>(3);
        model.put(ExcelView.FILENAME_KEY, "评委数据");
        model.put(ExcelView.PROPERTY_KEY, properties);
        model.put(ExcelView.CONTENT_KEY, contents);
        //返回视图
        return new ModelAndView(new ExcelView(), model);
    }

}
