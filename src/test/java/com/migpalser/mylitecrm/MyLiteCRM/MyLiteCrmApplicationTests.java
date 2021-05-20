package com.migpalser.mylitecrm.MyLiteCRM;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import com.migpalser.mylitecrm.MyLiteCrm.Customer;
import com.migpalser.mylitecrm.MyLiteCrm.CustomerRepository;

@SpringBootTest
@Sql({"/schema.sql","/data.sql"})
class MyLiteCrmApplicationTests {

	@Autowired
	CustomerRepository repository;
	
	@Test
	void contextLoads() {
	}

	@Test
	void searchAll() {
		Iterable<Customer> all=repository.findAll();
		boolean isPaco=false;
		for (Customer customer : all) {
			if(customer.getName().equals("Paco"))isPaco=true;
		}
		assertTrue(isPaco);
	}
	
}
