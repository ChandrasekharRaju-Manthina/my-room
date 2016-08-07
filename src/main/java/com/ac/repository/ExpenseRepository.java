package com.ac.repository;

import java.util.List;

import com.ac.model.Expense;

public interface ExpenseRepository {

	 List<Expense> findAll();
	

}
