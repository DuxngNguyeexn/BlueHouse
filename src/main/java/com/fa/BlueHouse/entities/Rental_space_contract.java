package com.fa.BlueHouse.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "RENTAL_SPACE_CONTRACT")
public class Rental_space_contract {

	@Id
	private String Contract_code;

	private String Tenant_code;

	@ManyToOne
	@JoinColumn(name = "Manager_codeContract")
	private Employee Manager_codeContract;

	private LocalTime Duration;

	private LocalDate Move_in_date;

	private LocalDate Move_out_date;

	@OneToOne
	@JoinColumn(name = "ID_Apa")
	private Apartment ID_Apa;

	public Rental_space_contract(String contract_code, String tenant_code, Employee manager_codeContract,
			LocalTime duration, LocalDate move_in_date, LocalDate move_out_date, Apartment iD_Apa) {
		super();
		Contract_code = contract_code;
		Tenant_code = tenant_code;
		Manager_codeContract = manager_codeContract;
		Duration = duration;
		Move_in_date = move_in_date;
		Move_out_date = move_out_date;
		ID_Apa = iD_Apa;
	}

	public String getContract_code() {
		return Contract_code;
	}

	public void setContract_code(String contract_code) {
		Contract_code = contract_code;
	}

	public String getTenant_code() {
		return Tenant_code;
	}

	public void setTenant_code(String tenant_code) {
		Tenant_code = tenant_code;
	}

	public Employee getManager_codeContract() {
		return Manager_codeContract;
	}

	public void setManager_codeContract(Employee manager_codeContract) {
		Manager_codeContract = manager_codeContract;
	}

	public LocalTime getDuration() {
		return Duration;
	}

	public void setDuration(LocalTime duration) {
		Duration = duration;
	}

	public LocalDate getMove_in_date() {
		return Move_in_date;
	}

	public void setMove_in_date(LocalDate move_in_date) {
		Move_in_date = move_in_date;
	}

	public LocalDate getMove_out_date() {
		return Move_out_date;
	}

	public void setMove_out_date(LocalDate move_out_date) {
		Move_out_date = move_out_date;
	}

	public Apartment getID_Apa() {
		return ID_Apa;
	}

	public void setID_Apa(Apartment iD_Apa) {
		ID_Apa = iD_Apa;
	}

	public Rental_space_contract() {
		super();
	}

}
