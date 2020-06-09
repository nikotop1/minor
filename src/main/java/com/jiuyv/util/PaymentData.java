package com.jiuyv.util;
import com.deepoove.poi.data.MiniTableRenderData;
import com.deepoove.poi.el.Name;
public class PaymentData {
	private MiniTableRenderData order;
    
	@Name("detail_table")
    private DetailData detailTable;
    
    private String invoiceDate;
    
    private String invoiceNo;
    
    private String customerName;
    
    private String taxPrice;
    
    private String exTaxPrice;
    
    private String taxAmount;
    
    private String invoiceTable;
    
    private String applyComments;
    
    private String reviewUser ; 
    
    private String applyUser ;

	public MiniTableRenderData getOrder() {
		return order;
	}

	public void setOrder(MiniTableRenderData order) {
		this.order = order;
	}

	public DetailData getDetailTable() {
		return detailTable;
	}

	public void setDetailTable(DetailData detailTable) {
		this.detailTable = detailTable;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getTaxPrice() {
		return taxPrice;
	}

	public void setTaxPrice(String taxPrice) {
		this.taxPrice = taxPrice;
	}

	public String getExTaxPrice() {
		return exTaxPrice;
	}

	public void setExTaxPrice(String exTaxPrice) {
		this.exTaxPrice = exTaxPrice;
	}

	public String getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(String taxAmount) {
		this.taxAmount = taxAmount;
	}

	public String getInvoiceTable() {
		return invoiceTable;
	}

	public void setInvoiceTable(String invoiceTable) {
		this.invoiceTable = invoiceTable;
	}

	public String getApplyComments() {
		return applyComments;
	}

	public void setApplyComments(String applyComments) {
		this.applyComments = applyComments;
	}

	public String getReviewUser() {
		return reviewUser;
	}

	public void setReviewUser(String reviewUser) {
		this.reviewUser = reviewUser;
	}

	public String getApplyUser() {
		return applyUser;
	}

	public void setApplyUser(String applyUser) {
		this.applyUser = applyUser;
	} 
  
}
