package com.fa.BlueHouse.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Resident {
	@Id
	private String idResident;
	@ManyToOne
	@JoinColumn(name = "ID_APARTMENT")
	private Apartment apartment;

	public Resident() {
		super();
	}
	
}
