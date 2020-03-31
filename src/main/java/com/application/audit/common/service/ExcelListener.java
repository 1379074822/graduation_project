package com.application.audit.common.service;

import com.alibaba.excel.read.context.AnalysisContext;
import com.alibaba.excel.read.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author:
 * @time: 2020/3/30 14:30
 */
public class ExcelListener extends AnalysisEventListener {

    private List<Object> datas = new ArrayList<>();
    @Override
    public void invoke(Object o, AnalysisContext analysisContext) {
        datas.add(o);
        doSomething(o);
    }

    private void doSomething(Object object) {
        //1、入库调用接口
    }

    public List<Object> getDatas() {
        return datas;
    }

    public void setDatas(List<Object> datas) {
        this.datas = datas;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // datas.clear();//解析结束销毁不用的资源
    }
}
