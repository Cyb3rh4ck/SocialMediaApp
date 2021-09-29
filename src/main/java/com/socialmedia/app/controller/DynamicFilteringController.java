package com.socialmedia.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.socialmedia.app.bean.SomeBeanFilter;

@RestController
public class DynamicFilteringController {
	
	@GetMapping("/filtering-dynamic")
	public MappingJacksonValue retrieveSomeBean() {
		SomeBeanFilter someBeanFilter = new SomeBeanFilter("value1","value2","value3");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("value1","value2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(someBeanFilter);
		mapping.setFilters(filters);
		
		return mapping;
	}
	
	@GetMapping("/filtering-list")
	public MappingJacksonValue retrieveListOfSomeBeanFilter() {
		List<SomeBeanFilter> list = Arrays.asList(new SomeBeanFilter("value1","value2","value3"), 
				new SomeBeanFilter("value1","value2","value3"));
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("value2","value3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
				
		MappingJacksonValue mapping = new MappingJacksonValue(list);
		mapping.setFilters(filters);
		return mapping;
	}
}
