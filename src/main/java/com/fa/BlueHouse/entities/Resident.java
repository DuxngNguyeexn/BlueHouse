package com.fa.BlueHouse.entities;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Resident {
	@Id
	private String idResident;
	private String nameResident;
	@ManyToOne
	private Apartment idApartment;
	private String relationshipHousehold;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthday;
	private String phonenumber;
	private String workplace;
	private String IdentificationCard;
	@OneToMany(mappedBy = "idResident")
	private List<Administrators> listAdmin;

	public List<Administrators> getListAdmin() {
		return listAdmin;
	}

	public void setListAdmin(List<Administrators> listAdmin) {
		this.listAdmin = listAdmin;
	}

	public String getIdResident() {
		return idResident;
	}

	public void setIdResident(String idResident) {
		this.idResident = idResident;
	}

	public String getNameResident() {
		return nameResident;
	}

	public void setNameResident(String nameResident) {
		this.nameResident = nameResident;
	}

	public Apartment getIdApartment() {
		return idApartment;
	}

	public void setIdApartment(Apartment idApartment) {
		this.idApartment = idApartment;
	}

	public String getRelationshipHousehold() {
		return relationshipHousehold;
	}

	public void setRelationshipHousehold(String relationshipHousehold) {
		this.relationshipHousehold = relationshipHousehold;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getWorkplace() {
		return workplace;
	}

	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}

	public String getIdentificationCard() {
		return IdentificationCard;
	}

	public void setIdentificationCard(String identificationCard) {
		IdentificationCard = identificationCard;
	}

	public Resident(String idResident, String nameResident, Apartment idApartment, String relationshipHousehold,
			LocalDate birthday, String phonenumber, String workplace, String identificationCard) {
		super();
		this.idResident = idResident;
		this.nameResident = nameResident;
		this.idApartment = idApartment;
		this.relationshipHousehold = relationshipHousehold;
		this.birthday = birthday;
		this.phonenumber = phonenumber;
		this.workplace = workplace;
		IdentificationCard = identificationCard;
	}

	public Resident() {
		super();
	}

	@Override
	public String toString() {
		return "Resident [getIdResident()=" + getIdResident() + ", getNameResident()=" + getNameResident()
				+ ", getRelationshipHousehold()=" + getRelationshipHousehold() + ", getBirthday()=" + getBirthday()
				+ ", getPhonenumber()=" + getPhonenumber() + ", getWorkplace()=" + getWorkplace()
				+ ", getIdentificationCard()=" + getIdentificationCard() + "]";
	}

}
