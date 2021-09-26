package com.socialmedia.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.app.bean.HelloWorldBean;

@RestController
public class HelloWorldController {
	
	@GetMapping("/hello-wordl")
	public String helloWorld() {
		return "Hello World";
	}

	@GetMapping("/hello-wordl-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	@GetMapping("/hello-wordl/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean("Hello World " + name);
	}
}
