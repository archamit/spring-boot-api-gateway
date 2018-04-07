package com.car.insurance.feign.domains;

import java.io.Serializable;

public class ResponseData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6634817221364613345L;
	
	private String responseCode;
	
	private String responseMessage;

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	

}
