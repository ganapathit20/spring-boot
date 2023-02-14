package com.exterro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exterro.model.Employee;
import com.exterro.service.EmployeeService;

@RestController
public class MainController {

	@Autowired
	private EmployeeService empService;

	@GetMapping("/getAllEmp")
	public List<Employee> getEmployee() {
		return empService.findAll();
	}

	@GetMapping("/getEmp/{eid}")
	public Employee getOneEmployee(@PathVariable int eid) {

		Employee emp = empService.findById(eid);

		if (emp == null)
			throw new RuntimeException("Emplyee not found " + eid);

		return emp;
	}

	@PostMapping("/insertEmp")
	public Employee createEmployee(@RequestBody Employee emp) {

		emp.setEid(0);

		empService.save(emp);

		return emp;
	}

	@PutMapping("/upsertEmp")
	public Employee updateEmployee(@RequestBody Employee emp) {

		empService.save(emp);

		return emp;
	}

	@DeleteMapping("/removeEmp/{eid}")
	public String removeEmployee(@PathVariable int eid) {

		Employee emp = empService.findById(eid);

		if (emp == null)
			throw new RuntimeException("Emplyee not found " + eid);

		empService.deleteById(eid);
		
		return "Deleted employee id " + eid;
	}
}
