package com.stacksimplify.restservices.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.stacksimplify.restservices.entities.UserDetails;

@RestController
public class HelloWorldController {
	@Autowired
	ResourceBundleMessageSource resourceBundleMessageSource;
	@GetMapping("/helloworld")
	public String helloWorld() {

		System.out.println("code of master");
		System.out.println("code of branch");
		return "Hello World";
	}
	@GetMapping("/helloworldbean")
	public UserDetails helloWorldBean() {
		return new UserDetails("Girish", "Jarmali", "Chitradurga");
	}
	@GetMapping("/helloworld-int1")
	public String getMessageInI18NFormat(@RequestHeader(name = "Accept-Language", required=false) String locale) {
		return resourceBundleMessageSource.getMessage("lable.hello", null, new Locale(locale));
		
	}
	@GetMapping("/helloworld-int2")
	public String getMessageInI18NFormat2() {
		return resourceBundleMessageSource.getMessage("lable.hello", null, LocaleContextHolder.getLocale());
		
	}
}
