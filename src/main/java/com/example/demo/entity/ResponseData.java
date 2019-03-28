package com.example.demo.entity;

/**
 * This is used to form appropriate messages to be sent to frontend
 * 
 * @author Chandra Kanth
 *
 */
public class ResponseData {
	
	/**
	 * The response code from resulting action
	 */
	String responseCode;
	
	/**
	 * Response message that explains the response code
	 */
	String responseMsg;
	
	/**
	 * Time of action
	 */
	String time;

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMsg() {
		return responseMsg;
	}

	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	

}
