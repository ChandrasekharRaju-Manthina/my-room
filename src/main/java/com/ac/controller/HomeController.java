package com.ac.controller;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	Environment environment;

	

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		logger.info("Active profiles" + Arrays.toString(environment.getActiveProfiles()));
		return "home";
	}
	
	@RequestMapping(value = "/home-temp", method = RequestMethod.GET)
	public String homeTest() {
		logger.info("Active profiles" + Arrays.toString(environment.getActiveProfiles()));
		return "home-temp";
	}

	@RequestMapping(value = "/metrics", method = RequestMethod.GET)
	public String metrics() {
		return "metrics";
	}

	@RequestMapping(value = "/overview", method = RequestMethod.GET)
	public String overview() {
		return "overview";
	}

	

}
