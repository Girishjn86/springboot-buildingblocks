package com.stacksimplify.restservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stacksimplify.restservices.entities.UserDetails;

@RestController
public class HelloWorldController {
	@GetMapping("/helloworld")
	public String helloWorld() {
		System.out.println("code of master");
		return "Hello World";
	}
	@GetMapping("helloworldbean")
	public UserDetails helloWorldBean() {
		return new UserDetails("Girish", "Jarmali", "Chitradurga");
	}
}
