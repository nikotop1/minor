package com.jiuyv.excel;

public class BankStatement {
	
	private String bankSerialNumber ;
	
	private String payer;

	private String payBankName;

	private String payBankId;

	private String payWay;

	private String payDay;

	private String totalAmount;
 
	private String currency;

	private String serviceCharge;

	private String paymentMethod  ;

	private String collectionDate ;
	
	private String receivingBankShortName;
	
	private String receivingBank;
	
	private String receivingBankId;

	private String serialId;
	
	private String summary;

	public String getBankSerialNumber() {
		return bankSerialNumber;
	}

	public void setBankSerialNumber(String bankSerialNumber) {
		this.bankSerialNumber = bankSerialNumber;
	}

	public String getPayer() {
		return payer;
	}

	public void setPayer(String payer) {
		this.payer = payer;
	}

	public String getPayBankName() {
		return payBankName;
	}

	public void setPayBankName(String payBankName) {
		this.payBankName = payBankName;
	}

	public String getPayBankId() {
		return payBankId;
	}

	public void setPayBankId(String payBankId) {
		this.payBankId = payBankId;
	}

	public String getPayWay() {
		return payWay;
	}

	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}

	public String getPayDay() {
		return payDay;
	}

	public void setPayDay(String payDay) {
		this.payDay = payDay;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(String serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getCollectionDate() {
		return collectionDate;
	}

	public void setCollectionDate(String collectionDate) {
		this.collectionDate = collectionDate;
	}

	public String getReceivingBankShortName() {
		return receivingBankShortName;
	}

	public void setReceivingBankShortName(String receivingBankShortName) {
		this.receivingBankShortName = receivingBankShortName;
	}

	public String getReceivingBank() {
		return receivingBank;
	}

	public void setReceivingBank(String receivingBank) {
		this.receivingBank = receivingBank;
	}

	public String getReceivingBankId() {
		return receivingBankId;
	}

	public void setReceivingBankId(String receivingBankId) {
		this.receivingBankId = receivingBankId;
	}

	public String getSerialId() {
		return serialId;
	}

	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Override
	public String toString() {
		return "BankStatement [bankSerialNumber=" + bankSerialNumber + ", payer=" + payer + ", payBankName="
				+ payBankName + ", payBankId=" + payBankId + ", payWay=" + payWay + ", payDay=" + payDay
				+ ", totalAmount=" + totalAmount + ", currency=" + currency + ", serviceCharge=" + serviceCharge
				+ ", paymentMethod=" + paymentMethod + ", collectionDate=" + collectionDate
				+ ", receivingBankShortName=" + receivingBankShortName + ", receivingBank=" + receivingBank
				+ ", receivingBankId=" + receivingBankId + ", serialId=" + serialId + ", summary=" + summary + "]";
	}
	
	
}
