package com.migpalser.mylitecrm.MyLiteCrm;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, String> {

	public List<Customer> findByName(String name);
	public List<Customer> findBySurnames(String surnames);
	public List<Customer> findByEmail(String email);
	public List<Customer> findByPhonenumber(int phonenumber);
	public List<Customer> findByNameAndSurnames(String name, String surnames);
	public List<Customer> findBySurnamesContaining(String surnames);

}
