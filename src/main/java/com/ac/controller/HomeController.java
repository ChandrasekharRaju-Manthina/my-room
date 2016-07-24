package com.ac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		System.out.println("JDBC Url: " + System.getenv("JDBC_DATABASE_URL"));
		return "home";
	}

}
