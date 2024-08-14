package com.fa.BlueHouse.entities.form;

import com.fa.BlueHouse.entities.Resident;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Report extends form {

	@ManyToOne
	@JoinColumn(name = "Id_Admin")
	Resident admin;

	public Report() {
		super();
	}

	public Report(Resident admin) {
		super();
		this.admin = admin;
	}

	public Resident getAdmin() {
		return admin;
	}

	public void setAdmin(Resident admin) {
		this.admin = admin;
	}

	
}
