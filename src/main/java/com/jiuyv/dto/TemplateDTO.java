package com.jiuyv.dto;

import com.jiuyv.entity.Template;

public class TemplateDTO extends Template {

    private String statusMsg;
    
    private String TypeMsg;
    
	public String getStatusMsg() {
		return statusMsg;
	}
	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}
	public String getTypeMsg() {
		return TypeMsg;
	}
	public void setTypeMsg(String typeMsg) {
		TypeMsg = typeMsg;
	}


}