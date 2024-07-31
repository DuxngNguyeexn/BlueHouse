package com.fa.BlueHouse.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "EMPLOYEEWORK")
public class EmployeeWork implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "ID_CALENDAR")
	private CalendarWoking calendarID;

	@Id
	@ManyToOne
	@JoinColumn(name = "ID_EMPLOYEE")
	private Employee employeeID;

	public CalendarWoking getCalendarID() {
		return calendarID;
	}

	public void setCalendarID(CalendarWoking calendarID) {
		this.calendarID = calendarID;
	}

	public Employee getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Employee employeeID) {
		this.employeeID = employeeID;
	}

	public EmployeeWork(CalendarWoking calendarID, Employee employeeID) {
		super();
		this.calendarID = calendarID;
		this.employeeID = employeeID;
	}

	public EmployeeWork() {
		super();
	}

}
