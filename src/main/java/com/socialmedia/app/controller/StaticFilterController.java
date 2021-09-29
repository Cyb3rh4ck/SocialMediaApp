package com.socialmedia.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.app.bean.SomeBean;

@RestController
public class StaticFilterController {

	@GetMapping("static-filter")
	public List<SomeBean> statiFilter() {
		return Arrays.asList(new SomeBean("value1", "value2", "value3"), 
				new SomeBean("value2-1","value2-2","value2-3"));
	}
}
