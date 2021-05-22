package com.migpalser.mylitecrm.MyLiteCrm;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="customers")
public interface CustomerRepository extends CrudRepository<Customer, String> {

	public List<Customer> findByName(String name);
	public List<Customer> findBySurnames(String surnames);
	public List<Customer> findByEmail(String email);
	public List<Customer> findByPhonenumber(int phonenumber);
	public List<Customer> findByNameAndSurnames(String name, String surnames);
	public List<Customer> findBySurnamesContaining(String surnames);
	//public List<Customer> findByPhonenumberNull(int phonenumber);
	//public List<Customer> findByNameNull(String name);
	//public List<Customer> findByPhonenumberIn(int phonenumber);


}
