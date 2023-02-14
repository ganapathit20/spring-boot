package com.exterro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import com.exterro.dao.IEmployeeDAO;
import com.exterro.model.Employee;

@Service
public class EmployeeService implements IEmployeeService{
	
	@Autowired
	private IEmployeeDAO empDao;

	@Override
	@Transactional
	public List<Employee> findAll() {
		return empDao.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		return empDao.findById(id);
	}

	@Override
	@Transactional
	public void save(Employee emp) {
		 empDao.save(emp);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		 empDao.deleteById(id);
	}

}
