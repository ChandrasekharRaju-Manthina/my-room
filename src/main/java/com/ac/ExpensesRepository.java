package com.ac;

import java.math.BigInteger;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ExpensesRepository extends PagingAndSortingRepository<Expense, BigInteger> {

}
