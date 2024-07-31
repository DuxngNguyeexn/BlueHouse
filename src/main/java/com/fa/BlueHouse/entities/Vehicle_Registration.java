package com.fa.BlueHouse.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "VEHICLE_REGISTRATION")
public class Vehicle_Registration {

	@Id
	private String ID_Vehicle;

	@ManyToOne
	@JoinColumn(name = "Fee_type_code")
	private FeeType Fee_type_code;

	private LocalDate Registration_date;

	private LocalDate Expiration_date;

	private String Vehicle_number;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_APARTMENT")
	private Apartment apartment_VE;

	public Vehicle_Registration() {
		super();
	}

	public Vehicle_Registration(String iD_Vehicle, FeeType fee_type_code, LocalDate registration_date,
			LocalDate expiration_date, String vehicle_number, Apartment apartment_VE) {
		super();
		ID_Vehicle = iD_Vehicle;
		Fee_type_code = fee_type_code;
		Registration_date = registration_date;
		Expiration_date = expiration_date;
		Vehicle_number = vehicle_number;
		this.apartment_VE = apartment_VE;
	}

	public String getID_Vehicle() {
		return ID_Vehicle;
	}

	public void setID_Vehicle(String iD_Vehicle) {
		ID_Vehicle = iD_Vehicle;
	}

	public FeeType getFee_type_code() {
		return Fee_type_code;
	}

	public void setFee_type_code(FeeType fee_type_code) {
		Fee_type_code = fee_type_code;
	}

	public LocalDate getRegistration_date() {
		return Registration_date;
	}

	public void setRegistration_date(LocalDate registration_date) {
		Registration_date = registration_date;
	}

	public LocalDate getExpiration_date() {
		return Expiration_date;
	}

	public void setExpiration_date(LocalDate expiration_date) {
		Expiration_date = expiration_date;
	}

	public String getVehicle_number() {
		return Vehicle_number;
	}

	public void setVehicle_number(String vehicle_number) {
		Vehicle_number = vehicle_number;
	}

	public Apartment getApartment_VE() {
		return apartment_VE;
	}

	public void setApartment_VE(Apartment apartment_VE) {
		this.apartment_VE = apartment_VE;
	}

}
