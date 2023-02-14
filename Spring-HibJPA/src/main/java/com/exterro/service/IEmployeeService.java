package com.exterro.service;

import java.util.List;

import com.exterro.model.Employee;

public interface IEmployeeService {
	
	List<Employee> findAll();
	
	Employee findById(int id);
	 
	void save(Employee emp);
	
	void deleteById(int id);

}
