package com.jiuyv.util;

import java.util.List;

import org.apache.poi.hssf.record.NumberRecord;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;

public class MyCellWriteHandler implements CellWriteHandler {

	@Override
	public void beforeCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row,
			Head head, Integer columnIndex, Integer relativeRowIndex, Boolean isHead) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Cell cell,
			Head head, Integer relativeRowIndex, Boolean isHead) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCellDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder,
			List<CellData> cellDataList, Cell cell, Head head, Integer relativeRowIndex, Boolean isHead) {


		HSSFWorkbook demoWorkBook = new HSSFWorkbook();
	
         
		 //创建workBook
		  HSSFWorkbook wb = new HSSFWorkbook();
		  //创建一个样式
		 HSSFCellStyle cellStyle = wb.createCellStyle();
		 //创建一个DataFormat对象
		HSSFDataFormat format = wb.createDataFormat();
		//这样才能真正的控制单元格格式，@就是指文本型，具体格式的定义还是参考上面的原文吧
		cellStyle.setDataFormat(format.getFormat("@"));
		
		//具体如何创建cell就省略了，最后设置单元格的格式这样写
		 cell.setCellStyle(cellStyle);
       

         cellStyle.setDataFormat(format.getFormat("@"));

         cell.setCellStyle(cellStyle);
        
	}

}
