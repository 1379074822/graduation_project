package com.application.audit.module.user.controller;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.application.audit.common.enums.AuditProfessionEnum;
import com.application.audit.common.enums.GenderEnum;
import com.application.audit.common.enums.StatusEnum;
import com.application.audit.common.service.Catagory;
import com.application.audit.common.service.ExcelListener;
import com.application.audit.module.user.entity.UserBO;
import com.application.audit.module.user.service.UserService;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @description:
 * @author:
 * @time: 2020/3/7 9:59
 */
@RestController
@RequestMapping("/user")

public class UserOperationController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    private UserBO login(@RequestBody UserBO userBO){
        return userService.findLoginAccountAndPasswordAndType(userBO);
    }

    @RequestMapping("/getInfo")
    private UserBO getInfo(Long userId){
        return userService.findById(userId);
    }

    @RequestMapping("/getAll")
    private List<UserBO> getAll(@RequestBody UserBO userBO){
        return userService.getAll(userBO);
    }

    @RequestMapping("/register")
    private Boolean register(UserBO userBO){
        UserBO save = userService.save(userBO);
        return Objects.nonNull(save);
    }

    @RequestMapping("/changePassword")
    private boolean changePassword(@RequestBody UserBO userBO){
        return  userService.changePassword(userBO);
    }

    @RequestMapping("/changeInfo")
    private UserBO changeInfo(@RequestBody UserBO userBO){
        return userService.changeInfo(userBO);
    }
    @RequestMapping("/init")
    private void init(){
         userService.init();
    }

    @RequestMapping("/getUserListSearch")
    private List<UserBO> getUserListSearch(@RequestBody UserBO userBO){
        List<UserBO> list = userService.getUserListSearch(userBO);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (UserBO bo : list) {
            bo.setStatusDesc(StatusEnum.getNameByIndex(bo.getStatus()));
            bo.setCreateTimeDesc(simpleDateFormat.format(bo.getCreateTime()));
            bo.setGenderDesc(GenderEnum.getNameByIndex(bo.getGender()));
            if(userBO.getType()==3){
            bo.setProfessionDesc(AuditProfessionEnum.getNameByIndex(bo.getProfession()));
            }
        }
        return list;
    }
    @RequestMapping("/upload")
    public void upload(@RequestParam("file") MultipartFile multipartFile) throws IOException, InvalidFormatException {
        InputStream inputStream = multipartFile.getInputStream();
        ExcelListener listener = new ExcelListener();
        //传入参数
        ExcelReader excelReader = new ExcelReader(inputStream, ExcelTypeEnum.XLS, null, listener);
        //读取信息
        excelReader.read(new Sheet(1, 1, Catagory.class));

        //获取数据
        List<Object> list = listener.getDatas();

        List<Catagory> catagoryList = new ArrayList<Catagory>();
        Catagory catagory = new Catagory();

        //转换数据类型,并插入到数据库
        for (int i = 0; i < list.size(); i++) {
            catagory = (Catagory) list.get(i);
            if(Objects.isNull(catagory.getPhone_num())){
                continue;
            }
            UserBO uu = userService.findByPhoneNum(catagory.getPhone_num());
            if(Objects.nonNull(uu)){
                continue;
            }
            UserBO userBO = new UserBO();
            userBO.setUserName(catagory.getUser_name());
            userBO.setLoginAccount(catagory.getPhone_num());
            userBO.setPassword("123");
            userBO.setPhoneNum(catagory.getPhone_num());
            userBO.setAge(catagory.getAge());
            userBO.setGender(GenderEnum.getIndexByName(catagory.getGender()));
            userBO.setProfession(AuditProfessionEnum.getIndexByName(catagory.getProfession()));
            userBO.setStatus(1);
            userBO.setType(3);
            userBO.setTicket(3);
            userBO.setCreateTime(new Date());
            userBO.setLevel("null".equals(catagory.getLevel())?null:catagory.getLevel());
            userBO.setWorkPerform("null".equals(catagory.getWork_perform())?null:catagory.getWork_perform());
            userBO.setResearchResult("null".equals(catagory.getResearch_result())?null:catagory.getResearch_result());
            userService.save(userBO);
        }

    }
}
