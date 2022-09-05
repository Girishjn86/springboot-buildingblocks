package com.stacksimplify.restservices.Exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
//@RestControllerAdvice
public class GlobalRestControllerAdviceException {
	@ExceptionHandler(UserNameNotFoundException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public final CustomErrorDetails userNameNotFoundExceptionHandler(UserNameNotFoundException ex) {
		return new CustomErrorDetails(new Date(),"From @restControllerAdvice",ex.getMessage());
	}
}
