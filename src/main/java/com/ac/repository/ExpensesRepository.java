package com.ac.repository;

import java.math.BigInteger;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ac.model.Expense;

public interface ExpensesRepository extends PagingAndSortingRepository<Expense, BigInteger> {

}
