package com.fa.BlueHouse.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Resident {
	@ManyToOne
	@JoinColumn(name = "ID_Resident")
	private Apartment apartment;
}
