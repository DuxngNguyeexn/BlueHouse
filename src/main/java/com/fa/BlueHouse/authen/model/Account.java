package com.fa.BlueHouse.authen.model;

import com.fa.BlueHouse.entities.Employee;
import com.fa.BlueHouse.entities.Resident;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ACCOUNT")
public class Account {

	@Id
	private String username;
	private String password;
	private int role;

	@OneToOne
	@JoinColumn(name = "employee_ID")
	private Employee employee;

	@OneToOne
	@JoinColumn(name = "resident_ID")
	private Resident resident;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Resident getResident() {
		return resident;
	}

	public void setResident(Resident resident) {
		this.resident = resident;
	}

	public Account() {
		super();
	}

	public Account(String username, String password, int role, Employee employee) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.employee = employee;
	}

	public Account(String username, String password, int role, Resident resident) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.resident = resident;
	}

	@Override
	public String toString() {
		return "Account [username=" + username + ", password=" + password + ", role=" + role + ", employee=" + employee
				+ ", resident=" + resident + "]";
	}

}
