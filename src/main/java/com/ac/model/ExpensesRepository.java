package com.ac.model;

import java.math.BigInteger;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ac.repository.Expense;

public interface ExpensesRepository extends PagingAndSortingRepository<Expense, BigInteger> {

}
