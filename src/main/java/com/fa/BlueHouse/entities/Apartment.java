package com.fa.BlueHouse.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Apartment {
	@Id
	@Column(name = "ID_Apartment")
	private String idaprtment;
	public String getIdaprtment() {
		return idaprtment;
	}

	public void setIdaprtment(String idaprtment) {
		this.idaprtment = idaprtment;
	}

	public Apartment(String idaprtment) {
		super();
		this.idaprtment = idaprtment;
	}

	public Apartment() {
		super();
	}

}
