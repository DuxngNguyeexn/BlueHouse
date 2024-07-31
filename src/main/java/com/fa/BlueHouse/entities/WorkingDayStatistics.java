package com.fa.BlueHouse.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "WORKINGDAYSTATISTICS")
public class WorkingDayStatistics {

	@Id
	@Column(name = "ID_STATISTICS")
	private String statisticsID;

	@Column(name = "COUNTDAYWORK")
	private int countDayWork;

	@Column(name = "COUNTDAYPERMIT")
	private int countDayPermitt;

	@Column(name = "COUNTDAYOFF")
	private int countDayOff;

	@Column(name = "SUMPERMIT")
	private int sumPermitt;

	@Column(name = "NOTE")
	private String note;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_EMPLOYEE")
	private Employee employeeID;

	public String getStatisticsID() {
		return statisticsID;
	}

	public void setStatisticsID(String statisticsID) {
		this.statisticsID = statisticsID;
	}

	public int getCountDayWork() {
		return countDayWork;
	}

	public void setCountDayWork(int countDayWork) {
		this.countDayWork = countDayWork;
	}

	public int getCountDayPermitt() {
		return countDayPermitt;
	}

	public void setCountDayPermitt(int countDayPermitt) {
		this.countDayPermitt = countDayPermitt;
	}

	public int getCountDayOff() {
		return countDayOff;
	}

	public void setCountDayOff(int countDayOff) {
		this.countDayOff = countDayOff;
	}

	public int getSumPermitt() {
		return sumPermitt;
	}

	public void setSumPermitt(int sumPermitt) {
		this.sumPermitt = sumPermitt;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Employee getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Employee employeeID) {
		this.employeeID = employeeID;
	}

	public WorkingDayStatistics(String statisticsID, int countDayWork, int countDayPermitt, int countDayOff,
			int sumPermitt, String note, Employee employeeID) {
		super();
		this.statisticsID = statisticsID;
		this.countDayWork = countDayWork;
		this.countDayPermitt = countDayPermitt;
		this.countDayOff = countDayOff;
		this.sumPermitt = sumPermitt;
		this.note = note;
		this.employeeID = employeeID;
	}

	public WorkingDayStatistics() {
		super();
	}

}
