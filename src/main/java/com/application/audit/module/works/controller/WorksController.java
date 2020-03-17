package com.application.audit.module.works.controller;

import com.application.audit.common.enums.ProfessionEnum;
import com.application.audit.common.enums.StatusEnum;
import com.application.audit.module.works.entity.CountWorksAO;
import com.application.audit.module.works.entity.CountWorksBO;
import com.application.audit.module.works.entity.WorksBO;
import com.application.audit.module.works.entity.WorksListBO;
import com.application.audit.module.works.service.WorksService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: lyc yuechuan.lian@luckincoffee.com
 * @time: 2020/3/8 9:42
 */
@RequestMapping("/works")
@RestController
public class WorksController {
    @Autowired
    private WorksService worksService;

    @RequestMapping("/saveWorks")
    private WorksBO saveWorks(@RequestBody WorksBO worksBO){
        return worksService.saveWorks(worksBO);
    }

    @RequestMapping("/updateWorks")
    private WorksBO updateWorks(@RequestBody WorksBO worksBO){
        return worksService.saveWorks(worksBO);
    }

    @RequestMapping("/all")
    private List<WorksBO> all(WorksBO worksBO){
        return worksService.all(worksBO);
    }

    /**
     * 查询作品
     * @param worksBO
     * @return
     */
    @RequestMapping("/getByQuery")
    private List<WorksBO> getByQuery(WorksBO worksBO){
        return worksService.all(worksBO);
    }

    /**
     * 汇总作品
     * @param worksBO
     * @return
     */
    @RequestMapping("/getSort")
    private List<WorksBO> getSort(WorksBO worksBO){
        return worksService.all(worksBO);
    }

    /**
     * 汇总作品(带评分）
     * @param worksBO
     * @return
     */
    @RequestMapping("/getAllWithScore")
    private List<WorksListBO> getAllWithScore(WorksBO worksBO){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<WorksListBO> worksListBOS = worksService.allWithScore(worksBO);
        for (WorksListBO worksListBO : worksListBOS) {
            worksListBO.setCreateTimeDesc(simpleDateFormat.format(worksListBO.getCreateTime()));
        }
        return worksListBOS;
    }

    /**
     * 汇总作品(带评分）
     * @param worksBO
     * @return
     */
    @RequestMapping("/getAllWithScoreSearch")
    private List<WorksListBO> getAllWithScoreSearch(@RequestBody  WorksBO worksBO){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<WorksListBO> worksListBOS = worksService.allWithScoreSearch(worksBO);
        for (WorksListBO worksListBO : worksListBOS) {
            worksListBO.setCreateTimeDesc(simpleDateFormat.format(worksListBO.getCreateTime()));
            worksListBO.setStatusDesc(StatusEnum.getNameByIndex(worksListBO.getStatus()));
        }
        return worksListBOS;
    }

     @RequestMapping("/getWorksByUser")
    private List<WorksListBO> getWorksByUser(Long createId){

        List<WorksListBO> worksListBOS = worksService.getWorksByUser(createId);

        return worksListBOS;
    }



    @RequestMapping("/getCount")
    private List<CountWorksAO> getCount(){
        List<CountWorksBO> list = worksService.getCount();
        ArrayList<CountWorksAO> countWorksAOS = new ArrayList<>();
        for (CountWorksBO countWorksBO : list) {
            CountWorksAO countWorksAO = new CountWorksAO();
            countWorksAO.setName(ProfessionEnum.getNameByIndex(countWorksBO.getType()));
            countWorksAO.setValue(countWorksBO.getValue());
            countWorksAOS.add(countWorksAO);
        }

        return countWorksAOS;
    }



    @RequestMapping("/getNew")
    private List<String> getNew(){
        List<String> list = worksService.getNew();
        return list;
    }

    @RequestMapping("/getHighScore")
    private List<WorksListBO> getHighScore(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<WorksListBO> list = worksService.getHighScore();
        for (WorksListBO worksListBO : list) {
            worksListBO.setCreateTimeDesc(simpleDateFormat.format(worksListBO.getCreateTime()));
        }
        return list;
    }

    @RequestMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        String prefix = "D:/image/";
        File file = new File(prefix + multipartFile.getOriginalFilename() );
        if(!file.exists()){
            //先得到文件的上级目录，并创建上级目录，在创建文件
            file.getParentFile().mkdir();
            try {
                //创建文件
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        IOUtils.copy(multipartFile.getInputStream(),fileOutputStream);
    return  "http://127.0.0.1:8083/" + multipartFile.getOriginalFilename();
    }
    //todo 作品导出
    //todo 评审结果
}
