package com.fa.BlueHouse.entities.form;

import com.fa.BlueHouse.entities.Employee;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Request extends form{
	
	
	@ManyToOne
	Employee employee;
	

	public Request() {
		super();
	}

	public Request( Employee employee) {
		super();
		this.employee = employee;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
