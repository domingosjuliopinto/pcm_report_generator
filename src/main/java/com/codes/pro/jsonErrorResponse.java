package com.codes.pro;

public class jsonErrorResponse extends SubjectMarks{
	
	private static final long serialVersionUID = 1L;
	private String message;
	private String details;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
}
