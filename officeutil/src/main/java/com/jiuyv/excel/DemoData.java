package com.jiuyv.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

//设置表头和添加的数据字段

public class DemoData extends BaseRowModel {

  //设置表头名称

  @ExcelProperty("序号")
  private int sno;
 
  @ExcelProperty("公司")
  private String cname;
  
  @ExcelProperty("产品线")
  private String productLine;
  
  @ExcelProperty("部门")
  private String department;
  
  @ExcelProperty("外付对象")
  private String outSourcingObject;
  
  @ExcelProperty({"应付","分包"})
  private String sSubcontract;
  
  @ExcelProperty({"应付","分成"})
  private String sShare;
  
  @ExcelProperty({"应付","佣金"})
  private String sCommission;
  
  @ExcelProperty({"应付","劳务费"})
  private String sLaborServiceFee;
  
  @ExcelProperty({"应付","小计"})
  private String sSubtotal;
  
  @ExcelProperty({"已付","分包"})
  private String hSubcontract;
  
  @ExcelProperty({"已付","分成"})
  private String hShare;
  
  @ExcelProperty({"已付","佣金"})
  private String hCommission;
  
  @ExcelProperty({"已付","劳务费"})
  private String hLaborServiceFee;
  
  @ExcelProperty({"已付","小计"})
  private String hSubtotal;
  
  @ExcelProperty({"未付","分包"})
  private String nSubcontract;
  
  @ExcelProperty({"未付","分成"})
  private String nShare;
  
  @ExcelProperty({"未付","佣金"})
  private String nCommission;
  
  @ExcelProperty({"未付","劳务费"})
  private String nLaborServiceFee;
  
  @ExcelProperty({"未付","小计"})
  private String nSubtotal;
   
  @ExcelProperty("币种")
  private String sname;

public int getSno() {
	return sno;
}

public void setSno(int sno) {
	this.sno = sno;
}

public String getCname() {
	return cname;
}

public void setCname(String cname) {
	this.cname = cname;
}

public String getProductLine() {
	return productLine;
}

public void setProductLine(String productLine) {
	this.productLine = productLine;
}

public String getDepartment() {
	return department;
}

public void setDepartment(String department) {
	this.department = department;
}

public String getOutSourcingObject() {
	return outSourcingObject;
}

public void setOutSourcingObject(String outSourcingObject) {
	this.outSourcingObject = outSourcingObject;
}

public String getsSubcontract() {
	return sSubcontract;
}

public void setsSubcontract(String sSubcontract) {
	this.sSubcontract = sSubcontract;
}

public String getsShare() {
	return sShare;
}

public void setsShare(String sShare) {
	this.sShare = sShare;
}

public String getsCommission() {
	return sCommission;
}

public void setsCommission(String sCommission) {
	this.sCommission = sCommission;
}

public String getsLaborServiceFee() {
	return sLaborServiceFee;
}

public void setsLaborServiceFee(String sLaborServiceFee) {
	this.sLaborServiceFee = sLaborServiceFee;
}

public String getsSubtotal() {
	return sSubtotal;
}

public void setsSubtotal(String sSubtotal) {
	this.sSubtotal = sSubtotal;
}

public String gethSubcontract() {
	return hSubcontract;
}

public void sethSubcontract(String hSubcontract) {
	this.hSubcontract = hSubcontract;
}

public String gethShare() {
	return hShare;
}

public void sethShare(String hShare) {
	this.hShare = hShare;
}

public String gethCommission() {
	return hCommission;
}

public void sethCommission(String hCommission) {
	this.hCommission = hCommission;
}

public String gethLaborServiceFee() {
	return hLaborServiceFee;
}

public void sethLaborServiceFee(String hLaborServiceFee) {
	this.hLaborServiceFee = hLaborServiceFee;
}

public String gethSubtotal() {
	return hSubtotal;
}

public void sethSubtotal(String hSubtotal) {
	this.hSubtotal = hSubtotal;
}

public String getnSubcontract() {
	return nSubcontract;
}

public void setnSubcontract(String nSubcontract) {
	this.nSubcontract = nSubcontract;
}

public String getnShare() {
	return nShare;
}

public void setnShare(String nShare) {
	this.nShare = nShare;
}

public String getnCommission() {
	return nCommission;
}

public void setnCommission(String nCommission) {
	this.nCommission = nCommission;
}

public String getnLaborServiceFee() {
	return nLaborServiceFee;
}

public void setnLaborServiceFee(String nLaborServiceFee) {
	this.nLaborServiceFee = nLaborServiceFee;
}

public String getnSubtotal() {
	return nSubtotal;
}

public void setnSubtotal(String nSubtotal) {
	this.nSubtotal = nSubtotal;
}

public String getSname() {
	return sname;
}

public void setSname(String sname) {
	this.sname = sname;
}


 
  
}
