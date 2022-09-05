package com.stacksimplify.restservices.Exceptions;

import java.util.Date;

public class CustomErrorDetails {
	private Date date;
	private String message;
	private String errorDeails;
	public CustomErrorDetails(Date date2, String message, String errorDeails) {
		super();
		this.date = date2;
		this.message = message;
		this.errorDeails = errorDeails;
	}
	public Date getDate() {
		return date;
	}
	public String getMessage() {
		return message;
	}
	public String getErrorDeails() {
		return errorDeails;
	}
		
}
