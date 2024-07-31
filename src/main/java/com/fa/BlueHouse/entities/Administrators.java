package com.fa.BlueHouse.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Administrators {
	@Id
	@Column(name = "ID_BQT")
	private String idBQT;
	@ManyToOne
	@JoinColumn(name = "ID_Resident")
	private Resident idResident;
	@ManyToOne
	@JoinColumn(name = "ID_Position")
	private Position idPosition;

	public String getIdBQT() {
		return idBQT;
	}

	public void setIdBQT(String idBQT) {
		this.idBQT = idBQT;
	}

	public Resident getIdResident() {
		return idResident;
	}

	public void setIdResident(Resident idResident) {
		this.idResident = idResident;
	}

	public Position getIdPosition() {
		return idPosition;
	}

	public void setIdPosition(Position idPosition) {
		this.idPosition = idPosition;
	}

	public Administrators(String idBQT, Resident idResident, Position idPosition) {
		super();
		this.idBQT = idBQT;
		this.idResident = idResident;
		this.idPosition = idPosition;
	}

	public Administrators() {
		super();
	}

}
