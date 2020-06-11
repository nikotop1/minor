package com.jiuyv.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.jiuyv.excel.BankStatement;
import com.jiuyv.excel.BankStatementListener;
import com.jiuyv.excel.NoModleDataListener;
import com.jiuyv.vo.ResultVO;

@RestController
@RequestMapping("/excelReader")
public class ExcelReadController {
	
    // 有对象的读
	@PostMapping("/readTest")
	public void readTest(MultipartFile file) {

		InputStream in;
		try {
			in = file.getInputStream();
			ExcelReader excelReader = EasyExcel.read(in, BankStatement.class, new BankStatementListener()).build();
			ReadSheet readSheet = EasyExcel.readSheet(0).build();
			excelReader.read(readSheet);
			// 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
			excelReader.finish();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	// 不创建对象的读
	@PostMapping("/readTestTwo")
	public void readTestTwo(MultipartFile file) {

		InputStream in;
		try {
			in = file.getInputStream();
			 EasyExcel.read(in, new NoModleDataListener()).sheet().doRead();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
