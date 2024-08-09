package com.fa.BlueHouse.entities;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Resident {
	@Id
	@Column(name = "ID_Resident")
	@NotBlank(message = "* ID Resident không được để trống")
	private String idResident;
	@Column(name = "Name_Resident")
	@NotBlank(message = "* Name Resident không được để trống")
	private String nameResident;
	@NotNull(message = "* Gender không được để trống")
	private String gender;
	@ManyToOne
	@JoinColumn(name = "ID_Apartment")

	private Apartment idApartment;
	@Column(name = "Relation")
	@NotBlank(message = "* Relationship không được để trống")
	private String relationshipHousehold;
	@NotNull(message = "* BirthDay không được để trống")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "BirthDay")
	private LocalDate birthday;
	@Column(name = "Phone_Number")
	@NotBlank(message = "* Phonenumber không được để trống")
	private String phonenumber;
	@Column(name = "WorkPlace")
	private String workplace;
	@Column(name = "Identifi_Card")
	@NotBlank(message = "* IdentificationCard không được để trống")
	private String identificationCard;
	@OneToMany(mappedBy = "idResident")
	private List<Administrators> listAdmin;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

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
		return identificationCard;
	}

	public void setIdentificationCard(String IdentificationCard) {
		identificationCard = IdentificationCard;
	}

	public Resident(String idResident, String nameResident, Apartment idApartment, String relationshipHousehold,
			LocalDate birthday, String phonenumber, String workplace, String IdentificationCard) {
		super();
		this.idResident = idResident;
		this.nameResident = nameResident;
		this.idApartment = idApartment;
		this.relationshipHousehold = relationshipHousehold;
		this.birthday = birthday;
		this.phonenumber = phonenumber;
		this.workplace = workplace;
		this.identificationCard = IdentificationCard;
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
