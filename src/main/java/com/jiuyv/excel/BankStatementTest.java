package com.jiuyv.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;

public class BankStatementTest {
	
public static void main(String[] args) {
	
	String fileName = "src\\main\\resources\\banktest.xlsx";
    ExcelReader excelReader = EasyExcel.read(fileName, BankStatement.class, new BankStatementListener()).build();
    ReadSheet readSheet = EasyExcel.readSheet(0).build();
    excelReader.read(readSheet);
    // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
    excelReader.finish();
}
}
