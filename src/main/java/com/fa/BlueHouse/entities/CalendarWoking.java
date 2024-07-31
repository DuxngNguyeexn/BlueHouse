package com.fa.BlueHouse.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "CALENDARWOKING")
public class CalendarWoking {

	@Id
	@Column(name = "ID_CALENDAR")
	private String calendarID;

	@Column(name = "TIMESTART", columnDefinition = "TIME")
	private LocalTime timeStart;

	@Column(name = "TIMEEND", columnDefinition = "TIME")
	private LocalTime timeEnd;

	@Column(name = "DAY", columnDefinition = "DATE")
	private LocalDate day;

	@Column(name = "TASK")
	private String task;

	@Column(name = "NOTE")
	private String note;

	@OneToMany(mappedBy = "calendarID", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<EmployeeWork> employeeWork;

	public String getCalendarID() {
		return calendarID;
	}

	public void setCalendarID(String calendarID) {
		this.calendarID = calendarID;
	}

	public LocalTime getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(LocalTime timeStart) {
		this.timeStart = timeStart;
	}

	public LocalTime getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(LocalTime timeEnd) {
		this.timeEnd = timeEnd;
	}

	public LocalDate getDay() {
		return day;
	}

	public void setDay(LocalDate day) {
		this.day = day;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Set<EmployeeWork> getEmployeeWork() {
		return employeeWork;
	}

	public void setEmployeeWork(Set<EmployeeWork> employeeWork) {
		this.employeeWork = employeeWork;
	}

	public CalendarWoking(String calendarID, LocalTime timeStart, LocalTime timeEnd, LocalDate day, String task,
			String note) {
		super();
		this.calendarID = calendarID;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.day = day;
		this.task = task;
		this.note = note;
	}

	public CalendarWoking() {
		super();
	}

}
