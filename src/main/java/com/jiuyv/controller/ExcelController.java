package com.jiuyv.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import com.jiuyv.excel.DemoDataOne;
import com.jiuyv.excel.ExcelFillCellMergeStrategy;

import io.swagger.annotations.ApiOperation;

import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/excelController")
public class ExcelController {

	@GetMapping("/getExcel")
	public void getExcel(HttpServletResponse response) throws IOException {
		// 获取数据源
		List<DemoDataOne> data = data();
		// 设置输入流，设置响应域
		response.setContentType("application/ms-excel");
		response.setCharacterEncoding("utf-8");
		String filename = "src/main/resources/write1.xlsx";
		response.setHeader("Content-disposition", "attachment;filename=" + filename);

		// 头的策略
		WriteCellStyle headWriteCellStyle = new WriteCellStyle();
		// 背景设置为红色
		headWriteCellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
		WriteFont headWriteFont = new WriteFont();
		headWriteFont.setFontHeightInPoints((short) 20);
		headWriteCellStyle.setWriteFont(headWriteFont);
		// 内容的策略
		WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
		// 这里需要指定 FillPatternType 为FillPatternType.SOLID_FOREGROUND 不然无法显示背景颜色.头默认了
		// FillPatternType所以可以不指定
		contentWriteCellStyle.setFillPatternType(FillPatternType.SOLID_FOREGROUND);
		// 背景绿色
		contentWriteCellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		WriteFont contentWriteFont = new WriteFont();
		// 字体大小
		contentWriteFont.setFontHeightInPoints((short) 20);
		contentWriteCellStyle.setWriteFont(contentWriteFont);
		// 这个策略是 头是头的样式 内容是内容的样式 其他的策略可以自己实现
		HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy(headWriteCellStyle,
				contentWriteCellStyle);
		// 需要合并的列
		int[] mergeColumeIndex = { 0, 3 };
		// 需要从第一行开始，列头第一行
		int mergeRowIndex = 5;
		EasyExcel// 将数据映射到DownloadDTO实体类并响应到浏览器
				.write(filename, DemoDataOne.class)
				// 07的excel版本,节省内存
				// .excelType(ExcelTypeEnum.XLSX)
				// 是否自动关闭输入流
				.autoCloseStream(Boolean.TRUE)
				// 设置样式
				// .registerWriteHandler(horizontalCellStyleStrategy)
				// 设置需要合并的行和列
				.registerWriteHandler(new ExcelFillCellMergeStrategy(mergeRowIndex, mergeColumeIndex))
//               // 自定义列宽度，有数字会
				.registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
				// 设置excel保护密码
//                .password("123456")
				.sheet().doWrite(data);
	}

	// TODO 解决中文乱码
	// 用swagger测试 这个生成的文件会乱码 直接访问没有问题
	@ApiOperation(value = "根据文件链接 任务类型下载文件", notes = "export", produces = "application/octet-stream")
	@GetMapping("/getExcelFromweb")
	public void getExcelfromweb(HttpServletResponse response) throws IOException {
		// 获取数据源
		List<DemoDataOne> data = data();
		// 设置输入流，设置响应域
		// response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-disposition", "attachment;filename=ceshi.xlsx");

		// 需要合并的列
		int[] mergeColumeIndex = { 0, 1, 2 };
		// 需要从第一行开始，列头第一行
		int mergeRowIndex = 5;
		EasyExcel// 将数据映射到DownloadDTO实体类并响应到浏览器
				.write(new BufferedOutputStream(response.getOutputStream()), DemoDataOne.class)
				// 是否自动关闭输入流
				.autoCloseStream(Boolean.TRUE)
				.registerWriteHandler(new ExcelFillCellMergeStrategy(mergeRowIndex, mergeColumeIndex))
				// 自定义列宽度，有数字会
				// .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
				// 设置excel保护密码
				// .password("123456")
				.sheet().doWrite(data);
	}

	// 获取数据的地方
	private static List<DemoDataOne> data() {
		List<DemoDataOne> list = new ArrayList<DemoDataOne>();
		for (int i = 0; i < 10; i++) {
			DemoDataOne data = new DemoDataOne();
			data.setString("字符串");
			data.setDate(new Date());
			data.setDoubleData(0.56);
			data.setId(UUID.randomUUID().toString().replaceAll("-", ""));
			list.add(data);
		}
		return list;
	}
}
