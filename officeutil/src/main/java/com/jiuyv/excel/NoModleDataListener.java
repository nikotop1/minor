package com.jiuyv.excel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

/**
 * 直接用map接收数据
 *
 * @author Jiaju Zhuang
 */
public class NoModleDataListener extends AnalysisEventListener<Map<Integer, String>> {
	
   
    List<Map<Integer, String>> list = new ArrayList<Map<Integer, String>>();

    @Override
    public void invoke(Map<Integer, String> data, AnalysisContext context) {
        System.out.println(data);
       
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
      
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
       
    }
}