package com.fa.BlueHouse.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public abstract class Apartment {

	@Id
	@Column(name = "ID_Apartment")
	private String ID_Apartment;
	
	private String Floor;

	private String Number_of_rooms ;

	private double Area;

	private String Apartment_number;
	
	@OneToMany(mappedBy = "apartment")
	List<Resident>  listCuDan;

	public Apartment() {
		super();
	}

	public Apartment(String iD_Apartment, String floor, String number_of_rooms, double area, String apartment_number) {
		super();
		ID_Apartment = iD_Apartment;
		Floor = floor;
		Number_of_rooms = number_of_rooms;
		Area = area;
		Apartment_number = apartment_number;
	}

	public String getID_Apartment() {
		return ID_Apartment;
	}

	public void setID_Apartment(String iD_Apartment) {
		ID_Apartment = iD_Apartment;
	}

	public String getFloor() {
		return Floor;
	}

	public void setFloor(String floor) {
		Floor = floor;
	}

	public String getNumber_of_rooms() {
		return Number_of_rooms;
	}

	public void setNumber_of_rooms(String number_of_rooms) {
		Number_of_rooms = number_of_rooms;
	}

	public double getArea() {
		return Area;
	}

	public void setArea(double area) {
		Area = area;
	}

	public String getApartment_number() {
		return Apartment_number;
	}

	public void setApartment_number(String apartment_number) {
		Apartment_number = apartment_number;
	}

	public List<Resident> getListCuDan() {
		return listCuDan;
	}

	public void setListCuDan(List<Resident> listCuDan) {
		this.listCuDan = listCuDan;
	}
	
	
	
	
}
