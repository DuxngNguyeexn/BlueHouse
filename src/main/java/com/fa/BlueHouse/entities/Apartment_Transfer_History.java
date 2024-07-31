package com.fa.BlueHouse.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "APARTMENT_TRANSFER_HISTORY")
public class Apartment_Transfer_History {

	@Id
	private String ID_Contract;

	@ManyToOne
	@JoinColumn(name = "ID_Resident")
	private Resident ID_resident;

	private String New_Homeowner;

	@ManyToOne
	@JoinColumn(name = "ID_APARTMENT")
	private Apartment apartment_transfer;

	private LocalDate Transfer_date;

	@ManyToOne
	@JoinColumn(name = "Manager_codeTransfer")
	private Employee Manager_codeTransfer;

	public String getID_Contract() {
		return ID_Contract;
	}

	public void setID_Contract(String iD_Contract) {
		ID_Contract = iD_Contract;
	}

	public Resident getID_resident() {
		return ID_resident;
	}

	public void setID_resident(Resident iD_resident) {
		ID_resident = iD_resident;
	}

	public String getNew_Homeowner() {
		return New_Homeowner;
	}

	public void setNew_Homeowner(String new_Homeowner) {
		New_Homeowner = new_Homeowner;
	}

	public Apartment getApartment_transfer() {
		return apartment_transfer;
	}

	public void setApartment_transfer(Apartment apartment_transfer) {
		this.apartment_transfer = apartment_transfer;
	}

	public LocalDate getTransfer_date() {
		return Transfer_date;
	}

	public void setTransfer_date(LocalDate transfer_date) {
		Transfer_date = transfer_date;
	}

	public Employee getManager_codeTransfer() {
		return Manager_codeTransfer;
	}

	public void setManager_codeTransfer(Employee manager_codeTransfer) {
		Manager_codeTransfer = manager_codeTransfer;
	}

	public Apartment_Transfer_History() {
		super();
	}

	public Apartment_Transfer_History(String iD_Contract, Resident iD_resident, String new_Homeowner,
			Apartment apartment_transfer, LocalDate transfer_date, Employee manager_codeTransfer) {
		super();
		ID_Contract = iD_Contract;
		ID_resident = iD_resident;
		New_Homeowner = new_Homeowner;
		this.apartment_transfer = apartment_transfer;
		Transfer_date = transfer_date;
		Manager_codeTransfer = manager_codeTransfer;
	}

}
