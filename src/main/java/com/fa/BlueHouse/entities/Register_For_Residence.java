package com.fa.BlueHouse.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "REGISTER_FOR_RESIDENCE")
public class Register_For_Residence {

	@Id
	private String ID_Residence;

	@ManyToOne
	@JoinColumn(name = "idResidentResi")
	private Resident idResidentResi;

	@ManyToOne
	@JoinColumn(name = "ID_ApartmentResi")
	private Apartment ID_ApartmentResi;

	private String Relationship_With_Homeowner;
	private String Type;
	private LocalDate Date_of_Birth;
	private String Phone;
	private LocalDate Move_In_Date;
	private LocalDate Move_out_Date;
	private String National_ID;

	@ManyToOne
	@JoinColumn(name = "Manager_CodeRegi")
	private Employee Manager_CodeRegi;

	public Register_For_Residence() {
		super();
	}

	public Register_For_Residence(String iD_Residence, Resident idResidentResi, Apartment iD_ApartmentResi,
			String relationship_With_Homeowner, String type, LocalDate date_of_Birth, String phone,
			LocalDate move_In_Date, LocalDate move_out_Date, String national_ID, Employee manager_Code) {
		super();
		ID_Residence = iD_Residence;
		this.idResidentResi = idResidentResi;
		ID_ApartmentResi = iD_ApartmentResi;
		Relationship_With_Homeowner = relationship_With_Homeowner;
		Type = type;
		Date_of_Birth = date_of_Birth;
		Phone = phone;
		Move_In_Date = move_In_Date;
		Move_out_Date = move_out_Date;
		National_ID = national_ID;
		Manager_CodeRegi = manager_Code;
	}

	public Employee getManager_Code() {
		return Manager_CodeRegi;
	}

	public void setManager_Code(Employee manager_Code) {
		Manager_CodeRegi = manager_Code;
	}

	public String getID_Residence() {
		return ID_Residence;
	}

	public void setID_Residence(String iD_Residence) {
		ID_Residence = iD_Residence;
	}

	public Resident getIdResidentResi() {
		return idResidentResi;
	}

	public void setIdResidentResi(Resident idResidentResi) {
		this.idResidentResi = idResidentResi;
	}

	public Apartment getID_ApartmentResi() {
		return ID_ApartmentResi;
	}

	public void setID_ApartmentResi(Apartment iD_ApartmentResi) {
		ID_ApartmentResi = iD_ApartmentResi;
	}

	public String getRelationship_With_Homeowner() {
		return Relationship_With_Homeowner;
	}

	public void setRelationship_With_Homeowner(String relationship_With_Homeowner) {
		Relationship_With_Homeowner = relationship_With_Homeowner;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public LocalDate getDate_of_Birth() {
		return Date_of_Birth;
	}

	public void setDate_of_Birth(LocalDate date_of_Birth) {
		Date_of_Birth = date_of_Birth;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public LocalDate getMove_In_Date() {
		return Move_In_Date;
	}

	public void setMove_In_Date(LocalDate move_In_Date) {
		Move_In_Date = move_In_Date;
	}

	public LocalDate getMove_out_Date() {
		return Move_out_Date;
	}

	public void setMove_out_Date(LocalDate move_out_Date) {
		Move_out_Date = move_out_Date;
	}

	public String getNational_ID() {
		return National_ID;
	}

	public void setNational_ID(String national_ID) {
		National_ID = national_ID;
	}

}
