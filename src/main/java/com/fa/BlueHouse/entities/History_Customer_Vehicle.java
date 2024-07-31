package com.fa.BlueHouse.entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "HISTORY_CUSTOMER_VEHICLE")
public class History_Customer_Vehicle implements Serializable {

	@EmbeddedId
	private History_Customer_Vehicle_ID id;

	private String Type;

	private LocalDate Move_Out_date;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_APARTMENT")
	private Apartment apartment_HIS;

	public History_Customer_Vehicle() {
		super();
	}

	public History_Customer_Vehicle(History_Customer_Vehicle_ID id, String type, LocalDate move_Out_date,
			Apartment apartment_HIS) {
		super();
		this.id = id;
		Type = type;
		Move_Out_date = move_Out_date;
		this.apartment_HIS = apartment_HIS;
	}

	public Apartment getApartment_HIS() {
		return apartment_HIS;
	}

	public void setApartment_HIS(Apartment apartment_HIS) {
		this.apartment_HIS = apartment_HIS;
	}

	public History_Customer_Vehicle_ID getId() {
		return id;
	}

	public void setId(History_Customer_Vehicle_ID id) {
		this.id = id;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public LocalDate getMove_Out_date() {
		return Move_Out_date;
	}

	public void setMove_Out_date(LocalDate move_Out_date) {
		Move_Out_date = move_Out_date;
	}

}
