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
@Table(name = "RENTALSPACECONTRACT")
public class RentalSpaceContract {

	@Id
	private String contractCode;

	private String tenantCode;

	@ManyToOne
	@JoinColumn(name = "ManagercodeContract")
	private Employee managerCodeContract;

	private LocalTime duration;

	private LocalDate moveInDate;

	private LocalDate moveOutdate;

	@OneToOne
	@JoinColumn(name = "ID_Apa")
	private Apartment idApa;

	public RentalSpaceContract() {
		super();
	}

	public RentalSpaceContract(String contractCode, String tenantCode, Employee managerCodeContract, LocalTime duration,
			LocalDate moveInDate, LocalDate moveOutdate, Apartment idApa) {
		super();
		this.contractCode = contractCode;
		this.tenantCode = tenantCode;
		this.managerCodeContract = managerCodeContract;
		this.duration = duration;
		this.moveInDate = moveInDate;
		this.moveOutdate = moveOutdate;
		this.idApa = idApa;
	}

	public String getContractCode() {
		return contractCode;
	}

	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}

	public String getTenantCode() {
		return tenantCode;
	}

	public void setTenantCode(String tenantCode) {
		this.tenantCode = tenantCode;
	}

	public Employee getManagerCodeContract() {
		return managerCodeContract;
	}

	public void setManagerCodeContract(Employee managerCodeContract) {
		this.managerCodeContract = managerCodeContract;
	}

	public LocalTime getDuration() {
		return duration;
	}

	public void setDuration(LocalTime duration) {
		this.duration = duration;
	}

	public LocalDate getMoveInDate() {
		return moveInDate;
	}

	public void setMoveInDate(LocalDate moveInDate) {
		this.moveInDate = moveInDate;
	}

	public LocalDate getMoveOutdate() {
		return moveOutdate;
	}

	public void setMoveOutdate(LocalDate moveOutdate) {
		this.moveOutdate = moveOutdate;
	}

	public Apartment getIdApa() {
		return idApa;
	}

	public void setIdApa(Apartment idApa) {
		this.idApa = idApa;
	}

}
