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
	
	private String imagePath;
	public Report() {
		super();
	}

	public Report(Resident admin,String imagePath) {
		super();
		this.admin = admin;
		this.imagePath = imagePath;
	}

	public Resident getAdmin() {
		return admin;
	}

	public void setAdmin(Resident admin) {
		this.admin = admin;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	
}
