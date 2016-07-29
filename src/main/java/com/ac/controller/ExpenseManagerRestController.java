package com.ac.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ac.model.Expense;
import com.ac.repository.ExpenseRepository;

@RestController
public class ExpenseManagerRestController {
	
	Logger logger = org.slf4j.LoggerFactory.getLogger(ExpenseManagerRestController.class);

	@Autowired
	ExpenseRepository repository;
	

	@RequestMapping(value = "/getExpenses", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Expense>> getExpenses() {
		logger.info("Enter into this method");
		return new ResponseEntity<List<Expense>>((List<Expense>) repository.findAll(), HttpStatus.OK);
	}
}
