package com.fa.BlueHouse.entities.form;

import com.fa.BlueHouse.entities.Employee;
import com.fa.BlueHouse.entities.Repair;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Request extends form{
	
	private String rate;
	@ManyToOne
	Employee employee;
	
	@OneToOne
	Repair repair;
	private String imagePath;
	
	public Request() {
		super();
	}

	public Request( Employee employee, Repair repair,String imagePath) {
		super();
		this.employee = employee;
		this.repair = repair;
		this.imagePath= imagePath;
		
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Repair getRepair() {
		return repair;
	}

	public void setRepair(Repair repair) {
		this.repair = repair;
	}
	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

}
