package com.vine.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ErrorDTO {
	public ErrorDTO() {
	}
	private String message;
	private int errorCode;
	
	private String type;
	
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return this.type;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
}
