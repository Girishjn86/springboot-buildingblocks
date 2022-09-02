package com.stacksimplify.restservices.services;

import org.springframework.stereotype.Service;

@Service
public class DTO {
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
}
