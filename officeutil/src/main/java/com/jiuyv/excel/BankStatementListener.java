package com.jiuyv.excel;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

public class BankStatementListener extends AnalysisEventListener<BankStatement>{
	
    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */

    
    List<BankStatement> list = new ArrayList<BankStatement>();
	@Override
	public void invoke(BankStatement data, AnalysisContext context) {
		
		System.out.println("解析到一条数据:"+data.toString());
       
		
	}

	@Override
	public void doAfterAllAnalysed(AnalysisContext context) {
		// TODO Auto-generated method stub
		
	}

}
