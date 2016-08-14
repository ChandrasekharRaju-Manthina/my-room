package com.ac.service;

import java.util.List;

import com.ac.model.Expense;

public interface ExpenseService {

	List<Expense> findAll();

	void addExpense(Expense expense);

}
