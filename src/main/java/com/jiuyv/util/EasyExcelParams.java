package com.jiuyv.util;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.ObjectUtils;

import com.alibaba.excel.metadata.BaseRowModel;

public class EasyExcelParams {
	/**
     * excel文件名（不带拓展名)
     */
    private String excelNameWithoutExt;
    /**
     * sheet名称
     */
    private String sheetName;
    /**
     * 是否需要表头
     */
    private boolean needHead = true;
    /**
     * 数据
     */
    private List<?> data;

    /**
     * 数据模型类型
     */
    private Class<?> dataModelClazz;

    /**
     * 响应
     */
    private HttpServletResponse response;
    
    private int[] mergeColumeIndex;
    
    private int mergeRowIndex ;


    public EasyExcelParams() {
    }


	public String getExcelNameWithoutExt() {
		return excelNameWithoutExt;
	}


	public void setExcelNameWithoutExt(String excelNameWithoutExt) {
		this.excelNameWithoutExt = excelNameWithoutExt;
	}


	public String getSheetName() {
		return sheetName;
	}


	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}


	public boolean isNeedHead() {
		return needHead;
	}


	public void setNeedHead(boolean needHead) {
		this.needHead = needHead;
	}


	public List<?> getData() {
		return data;
	}


	public void setData(List<?> data) {
		this.data = data;
	}


	public Class<?> getDataModelClazz() {
		return dataModelClazz;
	}


	public void setDataModelClazz(Class<?> dataModelClazz) {
		this.dataModelClazz = dataModelClazz;
	}


	public HttpServletResponse getResponse() {
		return response;
	}


	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}


	public int[] getMergeColumeIndex() {
		return mergeColumeIndex;
	}


	public void setMergeColumeIndex(int[] mergeColumeIndex) {
		this.mergeColumeIndex = mergeColumeIndex;
	}


	public int getMergeRowIndex() {
		return mergeRowIndex;
	}


	public void setMergeRowIndex(int mergeRowIndex) {
		this.mergeRowIndex = mergeRowIndex;
	}


    
}

