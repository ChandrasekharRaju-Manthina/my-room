package com.ac;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MyRoomApplication {

	@Autowired
	private ExpensesRepository repository;

	@RequestMapping("/")
	String home() {
		return "Hello World!" + "My changes are working!!";
	}

	@RequestMapping("/home")
	String lunchPad() {
		return "Anil : Hello World!" + "My changes are working!!";
	}

	@RequestMapping(value = "/createNewExpense", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Expense> createNewExpense(@RequestBody Expense expense) {
		return new ResponseEntity<Expense>(repository.save(expense), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/getAllExpenses", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Expense>> getAllExpenses() {
		return new ResponseEntity<List<Expense>>((List<Expense>) repository.findAll(), HttpStatus.OK);
	}

	public static void main(String[] args) {
		SpringApplication.run(MyRoomApplication.class, args);
	}
}
