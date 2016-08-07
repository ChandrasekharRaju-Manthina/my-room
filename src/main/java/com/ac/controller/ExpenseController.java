package com.ac.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ac.model.Expense;
import com.ac.service.ExpenseService;

@RestController
public class ExpenseController {

	Logger logger = org.slf4j.LoggerFactory.getLogger(ExpenseController.class);

	@Autowired
	private ExpenseService service; 

	@RequestMapping("/findAll")
	public ResponseEntity<List<Expense>> findAll() {
		return new ResponseEntity<List<Expense>>(service.findAll(),
				HttpStatus.OK);
	}

	

}
