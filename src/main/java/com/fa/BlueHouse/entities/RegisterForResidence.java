package com.fa.BlueHouse.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "REGISTER_FOR_RESIDENCE")
public class RegisterForResidence {

	@Id
	private String idResidence;

	@ManyToOne
	@JoinColumn(name = "idResidentResi")
	private Resident idResidentResi;

	@ManyToOne
	@JoinColumn(name = "ID_ApartmentResi")
	private Apartment idApartmentResi;

	private String relationshipWithHomeowner;
	private String type;
	private LocalDate dateOfBirth;
	private String phone;
	private LocalDate moveInDate;
	private LocalDate moveOutDate;
	private String idNational;

	@ManyToOne
	@JoinColumn(name = "Manager_CodeRegi")
	private Employee managerCodeRegi;

	public RegisterForResidence() {
		super();
	}

	public RegisterForResidence(String idResidence, Resident idResidentResi, Apartment idApartmentResi,
			String relationshipWithHomeowner, String type, LocalDate dateOfBirth, String phone, LocalDate moveInDate,
			LocalDate moveOutDate, String idNational, Employee managerCodeRegi) {
		super();
		this.idResidence = idResidence;
		this.idResidentResi = idResidentResi;
		this.idApartmentResi = idApartmentResi;
		this.relationshipWithHomeowner = relationshipWithHomeowner;
		this.type = type;
		this.dateOfBirth = dateOfBirth;
		this.phone = phone;
		this.moveInDate = moveInDate;
		this.moveOutDate = moveOutDate;
		this.idNational = idNational;
		this.managerCodeRegi = managerCodeRegi;
	}

	public String getIdResidence() {
		return idResidence;
	}

	public void setIdResidence(String idResidence) {
		this.idResidence = idResidence;
	}

	public Resident getIdResidentResi() {
		return idResidentResi;
	}

	public void setIdResidentResi(Resident idResidentResi) {
		this.idResidentResi = idResidentResi;
	}

	public Apartment getIdApartmentResi() {
		return idApartmentResi;
	}

	public void setIdApartmentResi(Apartment idApartmentResi) {
		this.idApartmentResi = idApartmentResi;
	}

	public String getRelationshipWithHomeowner() {
		return relationshipWithHomeowner;
	}

	public void setRelationshipWithHomeowner(String relationshipWithHomeowner) {
		this.relationshipWithHomeowner = relationshipWithHomeowner;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDate getMoveInDate() {
		return moveInDate;
	}

	public void setMoveInDate(LocalDate moveInDate) {
		this.moveInDate = moveInDate;
	}

	public LocalDate getMoveOutDate() {
		return moveOutDate;
	}

	public void setMoveOutDate(LocalDate moveOutDate) {
		this.moveOutDate = moveOutDate;
	}

	public String getIdNational() {
		return idNational;
	}

	public void setIdNational(String idNational) {
		this.idNational = idNational;
	}

	public Employee getManagerCodeRegi() {
		return managerCodeRegi;
	}

	public void setManagerCodeRegi(Employee managerCodeRegi) {
		this.managerCodeRegi = managerCodeRegi;
	}

}
