package com.ac.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ac.model.Expense;

@RepositoryRestResource(path="expenses")
public interface ExpenseRepository extends PagingAndSortingRepository<Expense, Long> {
	
}
