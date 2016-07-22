package com.ac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ExpenseManagerHomeController {

	@RequestMapping(value = "/dashBoard", method = RequestMethod.GET)
	public String greeting() {
		return "home";
	}

}
