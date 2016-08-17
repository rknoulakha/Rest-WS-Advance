package com.test.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	
	private String status;
	private String errorMessage;
	private int errorCode;
	
	
	
	public ErrorMessage() {
		
	}
	public ErrorMessage(String status, String errorMessage, int errorCode) {
		super();
		this.status = status;
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}
	public String getStatus() {
		return status;
	}
	@XmlElement
	public void setStatus(String status) {
		this.status = status;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	@XmlElement
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getErrorCode() {
		return errorCode;
	}
	@XmlElement
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	

}
