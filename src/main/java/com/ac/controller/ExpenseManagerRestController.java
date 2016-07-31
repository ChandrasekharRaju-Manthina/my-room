package com.ac.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ac.model.Expense;
import com.ac.repository.ExpenseRepository;

@RestController
public class ExpenseManagerRestController {

	Logger logger = org.slf4j.LoggerFactory.getLogger(ExpenseManagerRestController.class);

	@Autowired
	ExpenseRepository repository;

	@RequestMapping(value = "/getExpenses", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<List<Expense>> getExpenses() {
		logger.info("Enter into this method");
		return new ResponseEntity<List<Expense>>((List<Expense>) repository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/createExpense", method = RequestMethod.POST, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Expense> createExpense(@RequestBody Expense expense) {
		logger.info("Enter createExpense method");
		return new ResponseEntity<Expense>(repository.save(expense), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/deleteAll", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<String> deleteAll() {
		logger.info("Enter into this method");
		repository.deleteAll();
		return new ResponseEntity<String>("Deleted SuccessFully", HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
		Expense expense = repository.findOne(id);
		if (expense != null) {
			repository.delete(expense);
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}
	
	
	

}
