package com.fa.BlueHouse.entities.form;

import com.fa.BlueHouse.entities.Assets;
import com.fa.BlueHouse.entities.Employee;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Request extends form{
	
	@ManyToOne
	private Assets assets;
	
	@ManyToOne
	Employee employee;
	

	public Request() {
		super();
	}

	public Request(Assets assets, Employee employee) {
		super();
		this.assets = assets;
		this.employee = employee;
	}

	public Assets getAssets() {
		return assets;
	}

	public void setAssets(Assets assets) {
		this.assets = assets;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
