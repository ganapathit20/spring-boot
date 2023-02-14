package com.exterro.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="eid")
	private int eid;
	@Column(name="name")
	private String name;
	@Column(name="skill")
	private String skill;
	
	public Employee() {}
	
	public Employee(int eid, String name, String skill) {
		super();
		this.eid = eid;
		this.name = name;
		this.skill = skill;
	}
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", skill=" + skill + "]";
	}
	
	
	

}
