package com.ac.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ac.model.Expense;

@Repository
public class ExpenseRepositoryImpl implements ExpenseRepository {

	@PersistenceContext
	private EntityManager entityManager; 

	@Override
	public List<Expense> findAll() {
		return entityManager.createQuery("Select e From Expense e",
				Expense.class).getResultList();
	}

	
}
