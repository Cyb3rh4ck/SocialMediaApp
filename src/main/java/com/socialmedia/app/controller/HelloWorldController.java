package com.socialmedia.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@GetMapping("/hello-wordl")
	public String helloWorld() {
		return "Hello World";
	}

}
