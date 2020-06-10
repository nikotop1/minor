package com.jiuyv.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.Validate;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import com.jiuyv.excel.DemoDataOne;
import com.jiuyv.excel.ExcelFillCellMergeStrategy;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;

import org.apache.commons.codec.Charsets;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.apache.commons.lang3.ObjectUtils;
 
import javax.servlet.ServletOutputStream;

public class ExcelUtil {
	

	/**
	 * EasyExcel工具类
	 *
	 */

	    public void exportExcel(EasyExcelParams excelParams) throws IOException {
	        
	        EasyExcel
	                .write(excelParams.getExcelNameWithoutExt(), excelParams.getDataModelClazz())
	                // 07的excel版本,节省内存
	                //.excelType(ExcelTypeEnum.XLSX)
	                // 是否自动关闭输入流
	                .autoCloseStream(Boolean.TRUE)
	                // 设置样式
	                //.registerWriteHandler(horizontalCellStyleStrategy)
	                // 设置需要合并的行和列
	                .registerWriteHandler(new ExcelFillCellMergeStrategy(excelParams.getMergeRowIndex(), excelParams.getMergeColumeIndex()))
	               // 自定义列宽度，有数字会
	                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
	                //设置excel保护密码
	                //.password("123456")
	                .sheet().doWrite(excelParams.getData());
	    }
	 
	 
	 
	}

