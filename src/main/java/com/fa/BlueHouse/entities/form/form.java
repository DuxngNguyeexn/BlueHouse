package com.fa.BlueHouse.entities.form;

import java.util.Date;

import com.fa.BlueHouse.entities.Resident;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class form {
	@Id
	private String idForm;
	
	@ManyToOne
	@JoinColumn(name="Id_Resident")
	Resident resident;
	
	Date dateSent;
	String note;
	String status;
	public form() {
		super();
	}

	public form( Resident resident, Date dateSent, String note) {
		super();
		this.resident = resident;
		this.dateSent = dateSent;
		this.note = note;
	}

	
	public void setIdForm(String idForm) {
		this.idForm = idForm;
	}

	public String getIdForm() {
		return idForm;
	}

	public Resident getResident() {
		return resident;
	}

	public void setResident(Resident resident) {
		this.resident = resident;
	}

	public Date getDateSent() {
		return dateSent;
	}

	public void setDateSent(Date dateSent) {
		this.dateSent = dateSent;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}
