package com.ac.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ac.model.Expense;
import com.ac.service.ExpenseService;

@RestController("expenses")
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;

	@RequestMapping
	public List<Expense> findAll() {
		return expenseService.findAll();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void addExpense(Expense expense) {
		expenseService.addExpense(expense);
	}

}
