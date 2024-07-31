package com.fa.BlueHouse.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Requests {
	@Id
	String idRequest;

	@ManyToOne
	Resident resident;
	String typeRequest;
	Date sentDate;
	String reason;
	String note;

	@ManyToOne
	@JoinColumn(name = "employ_id")
	Employee employ;

	
	public Requests() {
		super();
	}

	public Requests(String idRequest, Resident resident, String typeRequest, Date sentDate, String reason, String note,
			Employee employ) {
		super();
		this.idRequest = idRequest;
		this.resident = resident;
		this.typeRequest = typeRequest;
		this.sentDate = sentDate;
		this.reason = reason;
		this.note = note;
		this.employ = employ;
	}

	public String getIdRequest() {
		return idRequest;
	}

	public void setIdRequest(String idRequest) {
		this.idRequest = idRequest;
	}

	public Resident getResident() {
		return resident;
	}

	public void setResident(Resident resident) {
		this.resident = resident;
	}

	public String getTypeRequest() {
		return typeRequest;
	}

	public void setTypeRequest(String typeRequest) {
		this.typeRequest = typeRequest;
	}

	public Date getSentDate() {
		return sentDate;
	}

	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Employee getEmploy() {
		return employ;
	}

	public void setEmploy(Employee employ) {
		this.employ = employ;
	}

	
	
}
