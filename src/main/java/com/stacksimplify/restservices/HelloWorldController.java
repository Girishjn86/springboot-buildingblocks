package com.stacksimplify.restservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	@GetMapping("/helloworld")
	public String helloWorld() {
		return "Hello World";
	}
	@GetMapping("helloworldbean")
	public UserDetails helloWorldBean() {
		return new UserDetails("Girish", "Jarmali", "Chitradurga");
	}
}
