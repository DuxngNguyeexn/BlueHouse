package com.fa.BlueHouse.entities;


import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

	@Id
	@Column(name = "ID_EMPLOYEE")
	private String employeeID;

	@Column(name = "Name")
	private String name;

	@Column(name = "Gender")
	private String gender;

	@Column(name = "PhoneNumber")
	private String phoneNumber;

	@Column(name = "DateOfBirth", columnDefinition = "DATE")
	private LocalDate dateOfBirth;

	@Column(name = "CCCD")
	private String CCCD;

	@Column(name = "AreaBorn")
	private String areaBorn;

	@Column(name = "Department")
	private String department;

	@Column(name = "Duty")
	private String duty;
//	======================One To Many=========================

	@OneToMany(mappedBy = "employeeID", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<HistoryOff> HistoryOffID;

//	=========================One To One==========================

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "MANAGER_ID")
	private Employee manager;

	@OneToMany(mappedBy = "manager", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Employee> under;
//	======================Many To Many==============================

	@OneToMany(mappedBy = "employeeID", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<EmployeeWork> employeeWork;

//	============================================================

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCCCD() {
		return CCCD;
	}

	public void setCCCD(String cCCD) {
		CCCD = cCCD;
	}

	public String getAreaBorn() {
		return areaBorn;
	}

	public void setAreaBorn(String areaBorn) {
		this.areaBorn = areaBorn;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public List<HistoryOff> getHistoryOffID() {
		return HistoryOffID;
	}

	public void setHistoryOffID(List<HistoryOff> historyOffID) {
		HistoryOffID = historyOffID;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public List<Employee> getUnder() {
		return under;
	}

	public void setUnder(List<Employee> under) {
		this.under = under;
	}

	public Set<EmployeeWork> getEmployeeWork() {
		return employeeWork;
	}

	public void setEmployeeWork(Set<EmployeeWork> employeeWork) {
		this.employeeWork = employeeWork;
	}

	public Employee(String employeeID, String name, String gender, String phoneNumber, LocalDate dateOfBirth,
			String cCCD, String areaBorn, String department, String duty, List<HistoryOff> historyOffID,
			Employee manager, List<Employee> under) {
		super();
		this.employeeID = employeeID;
		this.name = name;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		CCCD = cCCD;
		this.areaBorn = areaBorn;
		this.department = department;
		this.duty = duty;
		HistoryOffID = historyOffID;
		this.manager = manager;
		this.under = under;
	}

	public Employee() {
		super();
	}

}
