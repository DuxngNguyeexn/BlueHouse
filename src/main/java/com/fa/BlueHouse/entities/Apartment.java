package com.fa.BlueHouse.entities;

import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "APARTMENT")
public class Apartment {

	@Id
	@Column(name = "ID_APARTMENT")
	private String ID_Apartment;

	@Column(name = "ID_HOMEOWNER")
	private String ID_Homeowner;

	@Column(name = "FLOOR")
	private String Floor;

	@Column(name = "PRICE_MONTH")
	private LocalDate Price_Month;

	@Column(name = "NUMBER_OF_ROOMS")
	private String Number_of_rooms;

	@Column(name = "AREA")
	private double Area;

	@Column(name = "APARTMENT_NUMBER")
	private String Apartment_number;

	@Column(name = "TYPE_APARTMENT")
	private String Type_apartment;

	@OneToMany(mappedBy = "idApartment")
	List<Resident> listCuDan;

	@OneToMany(mappedBy = "apartment_VE")
	List<Vehicle_Registration> vehicle_Registrations;

	@OneToOne(mappedBy = "ID_Apa")
	private Rental_space_contract ren;

	@OneToMany(mappedBy = "apartment_HIS")
	List<History_Customer_Vehicle> listHistory_Customer;

	@OneToMany(mappedBy = "apartment_transfer")
	List<Apartment_Transfer_History> listapartment_Histories;

	public List<History_Customer_Vehicle> getListHistory_Customer() {
		return listHistory_Customer;
	}

	public void setListHistory_Customer(List<History_Customer_Vehicle> listHistory_Customer) {
		this.listHistory_Customer = listHistory_Customer;
	}

	public List<Apartment_Transfer_History> getListapartment_Histories() {
		return listapartment_Histories;
	}

	public void setListapartment_Histories(List<Apartment_Transfer_History> listapartment_Histories) {
		this.listapartment_Histories = listapartment_Histories;
	}

	public Apartment() {
		super();
	}

	public Apartment(String iD_Apartment, String iD_Homeowner, String floor, LocalDate price_Month,
			String number_of_rooms, double area, String apartment_number, String type_apartment) {
		super();
		ID_Apartment = iD_Apartment;
		ID_Homeowner = iD_Homeowner;
		Floor = floor;
		Price_Month = price_Month;
		Number_of_rooms = number_of_rooms;
		Area = area;
		Apartment_number = apartment_number;
		Type_apartment = type_apartment;
	}

	public List<History_Customer_Vehicle> getListHistory() {
		return listHistory_Customer;
	}

	public void setListHistory(List<History_Customer_Vehicle> listHistory) {
		this.listHistory_Customer = listHistory;
	}

	public String getID_Apartment() {
		return ID_Apartment;
	}

	public Rental_space_contract getRen() {
		return ren;
	}

	public void setRen(Rental_space_contract ren) {
		this.ren = ren;
	}

	public List<Vehicle_Registration> getVehicle_Registrations() {
		return vehicle_Registrations;
	}

	public void setVehicle_Registrations(List<Vehicle_Registration> vehicle_Registrations) {
		this.vehicle_Registrations = vehicle_Registrations;
	}

	public void setID_Apartment(String iD_Apartment) {
		ID_Apartment = iD_Apartment;
	}

	public String getID_Homeowner() {
		return ID_Homeowner;
	}

	public void setID_Homeowner(String iD_Homeowner) {
		ID_Homeowner = iD_Homeowner;
	}

	public String getFloor() {
		return Floor;
	}

	public void setFloor(String floor) {
		Floor = floor;
	}

	public LocalDate getPrice_Month() {
		return Price_Month;
	}

	public void setPrice_Month(LocalDate price_Month) {
		Price_Month = price_Month;
	}

	public List<Resident> getListCuDan() {
		return listCuDan;
	}

	public void setListCuDan(List<Resident> listCuDan) {
		this.listCuDan = listCuDan;
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

	public String getType_apartment() {
		return Type_apartment;
	}

	public void setType_apartment(String type_apartment) {
		Type_apartment = type_apartment;
	}

}
