package com.fa.BlueHouse.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class FeeType {
	@Id
	@Column(name = "ID_FeeType")
	private String idFeetype;
	@Column(name = "Name_FeeType")
	private String nameFeetype;
	@Column(name = "Price")
	private float price;

	@OneToMany(mappedBy = "Fee_type_code")
	List<Vehicle_Registration> vehicle_RegistrationsFEE;
	public String getIdFeetype() {
		return idFeetype;
	}

	@ManyToOne
	@JoinColumn(name = "ID_Apartment_Fee")
	private Apartment ID_Apartment_Fee;
	
	public List<Vehicle_Registration> getVehicle_RegistrationsFEE() {
		return vehicle_RegistrationsFEE;
	}

	public void setVehicle_RegistrationsFEE(List<Vehicle_Registration> vehicle_RegistrationsFEE) {
		this.vehicle_RegistrationsFEE = vehicle_RegistrationsFEE;
	}

	public Apartment getID_Apartment_Fee() {
		return ID_Apartment_Fee;
	}

	public void setID_Apartment_Fee(Apartment iD_Apartment_Fee) {
		ID_Apartment_Fee = iD_Apartment_Fee;
	}

	public void setIdFeetype(String idFeetype) {
		this.idFeetype = idFeetype;
	}

	public String getNameFeetype() {
		return nameFeetype;
	}

	public void setNameFeetype(String nameFeetype) {
		this.nameFeetype = nameFeetype;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public FeeType(String idFeetype, String nameFeetype, float price) {
		super();
		this.idFeetype = idFeetype;
		this.nameFeetype = nameFeetype;
		this.price = price;
	}

	public FeeType() {
		super();
	}

	@Override
	public String toString() {
		return "FeeType [getIdFeetype()=" + getIdFeetype() + ", getNameFeetype()=" + getNameFeetype() + ", getPrice()="
				+ getPrice() + "]";
	}

}
