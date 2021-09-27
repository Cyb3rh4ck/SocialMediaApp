package com.socialmedia.app.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.app.bean.HelloWorldBean;

@RestController
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource;

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

	@GetMapping("/hello-wordl-intetnationalized")
	public String helloWorldIntetnationalized(
//	 @RequestHeader(name = "Accept-Language", required=false) Locale locale
	) {
		return messageSource.getMessage("good.morning.message", null, "No language support",
//				locale);
				LocaleContextHolder.getLocale());
	}
}
