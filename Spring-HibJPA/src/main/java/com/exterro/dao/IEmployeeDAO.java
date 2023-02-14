package com.exterro.dao;

import java.util.List;

import com.exterro.model.Employee;

public interface IEmployeeDAO {
	
	List<Employee> findAll();
	
	Employee findById(int id);
	 
	void save(Employee emp);
	
	void deleteById(int id);
	
	

}
