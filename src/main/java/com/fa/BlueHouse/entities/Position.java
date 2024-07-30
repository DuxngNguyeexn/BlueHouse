package com.fa.BlueHouse.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Position {
	@Id
	private String idPosition;
	private String namePosition;
	private String prorogue;

	public String getIdPosition() {
		return idPosition;
	}

	public void setIdPosition(String idPosition) {
		this.idPosition = idPosition;
	}

	public String getNamePosition() {
		return namePosition;
	}

	public void setNamePosition(String namePosition) {
		this.namePosition = namePosition;
	}

	public String getProrogue() {
		return prorogue;
	}

	public void setProrogue(String prorogue) {
		this.prorogue = prorogue;
	}

	public Position(String idPosition, String namePosition, String prorogue) {
		super();
		this.idPosition = idPosition;
		this.namePosition = namePosition;
		this.prorogue = prorogue;
	}

	public Position() {
		super();
	}

	@Override
	public String toString() {
		return "Position [getIdPosition()=" + getIdPosition() + ", getNamePosition()=" + getNamePosition()
				+ ", getProrogue()=" + getProrogue() + "]";
	}

}
