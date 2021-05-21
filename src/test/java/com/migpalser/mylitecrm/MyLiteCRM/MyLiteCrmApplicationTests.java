package com.migpalser.mylitecrm.MyLiteCRM;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

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
	
	@Test
	void findById() {
		Optional<Customer> customer=repository.findById("paco@dummy.dumb");
		
		assertTrue(customer.get().getName().equals("Paco"));
	}
	
	@Test
	void save() {
		Customer c=new Customer();
		c.setEmail("pepe@dummy.dumb");
		
		repository.save(c);
		
		Optional<Customer> customer=repository.findById("pepe@dummy.dumb");
		
		assertTrue(customer.get().getEmail().equals("pepe@dummy.dumb"));
	}
	
	@Test
	void delete() {
		Customer c=new Customer();
		c.setEmail("paco@dummy.dumb");
		
		repository.delete(c);
		
		Optional<Customer> customer=repository.findById("paco@dummy.dumb");
		
		assertFalse(customer.isPresent());
	}
	
	@Test
	void findByName() {
		List<Customer> customers=repository.findByName("Paco");
		
		Customer c=new Customer();
		c.setEmail("paco@dummy.dumb");
		
		assertTrue(customers.contains(c));
	}
	
	@Test
	void findBySurname() {
		List<Customer> customers=repository.findBySurnames("Fulanez");
		
		Customer c=new Customer();
		c.setEmail("paco@dummy.dumb");
		
		assertTrue(customers.contains(c));
	}
	
	@Test
	void findByEmail() {
		List<Customer> customers=repository.findByEmail("paco@dummy.dumb");
		
		Customer c=new Customer();
		c.setEmail("paco@dummy.dumb");
		
		assertTrue(customers.contains(c));
	}
	
	@Test
	void findByPhonenumber() {
		List<Customer> customers=repository.findByPhonenumber(10001);
		
		Customer c=new Customer();
		c.setEmail("paco@dummy.dumb");
		
		assertTrue(customers.contains(c));
	}
	
	@Test
	void findByNameAndSurname() {
		List<Customer> customers=repository.findByNameAndSurnames("Paco","Fulanez");
		
		Customer c=new Customer();
		c.setEmail("paco@dummy.dumb");
		
		assertTrue(customers.contains(c));
	}
	
	@Test
	void findBySurnameContaining() {
		List<Customer> customers=repository.findBySurnamesContaining("Fula");
		
		Customer c=new Customer();
		c.setEmail("paco@dummy.dumb");
		
		assertTrue(customers.contains(c));
	}
}
