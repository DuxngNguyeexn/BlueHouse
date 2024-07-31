package com.fa.BlueHouse.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class History_Customer_Vehicle_ID implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String Vehicle_Number;

	private LocalDate Move_In_Date;

	public History_Customer_Vehicle_ID() {
		super();
	}

	public History_Customer_Vehicle_ID(String vehicle_Number, LocalDate move_In_Date) {
		super();
		Vehicle_Number = vehicle_Number;
		Move_In_Date = move_In_Date;
	}

	public String getVehicle_Number() {
		return Vehicle_Number;
	}

	public void setVehicle_Number(String vehicle_Number) {
		Vehicle_Number = vehicle_Number;
	}

	public LocalDate getMove_In_Date() {
		return Move_In_Date;
	}

	public void setMove_In_Date(LocalDate move_In_Date) {
		Move_In_Date = move_In_Date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Move_In_Date, Vehicle_Number);
	}

}
