package com.jiuyv.excel;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;

import java.util.Date;

//手动配置列行高
@ContentRowHeight(20)
@HeadRowHeight(20)
@ColumnWidth(20)
public class DemoDataOne {
	
	// @ColumnWidth(70)
    @ExcelProperty("字符串标题")
    private String string;
    
    // @ColumnWidth(70)
    @DateTimeFormat("yyyy-MM-dd")
    @ExcelProperty("日期标题")
    private Date date;
    
    // @ColumnWidth(70)
    @ExcelProperty("id")
    private String id;
    
      // 当前列的宽度
     @ColumnWidth(70) 
     @NumberFormat("##0.00") 
    @ExcelProperty("数字标题")
    private double doubleData;
    
    
    
    /**
     * 忽略这个字段
     */
    @ExcelIgnore
    private String ignore;



	public String getString() {
		return string;
	}



	public void setString(String string) {
		this.string = string;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public double getDoubleData() {
		return doubleData;
	}



	public void setDoubleData(double doubleData) {
		this.doubleData = doubleData;
	}



	public String getIgnore() {
		return ignore;
	}



	public void setIgnore(String ignore) {
		this.ignore = ignore;
	}
    
    
	
}
