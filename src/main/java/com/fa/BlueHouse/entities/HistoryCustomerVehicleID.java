package com.fa.BlueHouse.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class HistoryCustomerVehicleID implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String vehicleNumber;

	private LocalDate moveInDate;

	public HistoryCustomerVehicleID() {
		super();
	}

	public HistoryCustomerVehicleID(String vehicleNumber, LocalDate moveInDate) {
		super();
		this.vehicleNumber = vehicleNumber;
		this.moveInDate = moveInDate;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public LocalDate getMoveInDate() {
		return moveInDate;
	}

	public void setMoveInDate(LocalDate moveInDate) {
		this.moveInDate = moveInDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(moveInDate, vehicleNumber);
	}

}
