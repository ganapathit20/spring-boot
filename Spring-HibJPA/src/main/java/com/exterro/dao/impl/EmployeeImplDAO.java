package com.exterro.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exterro.dao.IEmployeeDAO;
import com.exterro.model.Employee;

import jakarta.persistence.EntityManager;

@Repository
public class EmployeeImplDAO implements IEmployeeDAO {

	@Autowired
	private EntityManager entity;

	@Override
	public List<Employee> findAll() {

		Session session = entity.unwrap(Session.class);

		Query<Employee> query = session.createQuery("from Employee", Employee.class);

		List<Employee> emp = query.getResultList();
		System.out.println(emp);
		return emp;
	}

	@Override
	public Employee findById(int id) {

		Session session = entity.unwrap(Session.class);

		Employee emp = session.get(Employee.class, id);

		return emp;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void save(Employee emp) {

		Session session = entity.unwrap(Session.class);

		session.saveOrUpdate(emp);
	}

	@Override
	public void deleteById(int id) {

		Session session = entity.unwrap(Session.class);

		Query<Employee> query = session.createQuery("delete from Employee where id=:eid");
		
		query.setParameter("eid", id);
		
		query.executeUpdate();

	}

}
