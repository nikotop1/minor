package com.jiuyv.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.jiuyv.excel.DemoDataOne;

public class TestExcel {

	public static void main(String[] args) throws IOException {
		ExcelUtil ex =new ExcelUtil();
		EasyExcelParams e = new EasyExcelParams() ;
		
		List<DemoDataOne> list = new ArrayList<DemoDataOne>();
        for (int i = 0; i < 10; i++) {
            DemoDataOne data = new DemoDataOne();
            data.setString("111111111111111111111111111111111111111111111111111111");
            data.setDate(new Date());
            data.setDoubleData(111111111111111.01);
            data.setId(UUID.randomUUID().toString().replaceAll("-",""));
            list.add(data);
        }
         
		e.setData(list);
		e.setDataModelClazz(DemoDataOne.class);
		// 设置文件名
		e.setExcelNameWithoutExt("test.xlsx");
		// 需要合并的列
		e.setMergeColumeIndex(new int[] {0,1});
		// 需要合并的行
		e.setMergeRowIndex(5);
		
		e.setSheetName("testsheetname");
		
		ex.exportExcel(e);
		
	}
	

}
