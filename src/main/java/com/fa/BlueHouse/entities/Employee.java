package com.fa.BlueHouse.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

	@Id
	@Column(name = "ID_EMPLOYEE")
	private String employeeID;

	@Column(name = "Name")
	private String fullName;

	@Column(name = "Gender")
	private String gender;

	@Column(name = "PhoneNumber")
	private String phoneNumber;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "DateOfBirth", columnDefinition = "DATE")
	private LocalDate dateOfBirth;

	@Column(name = "National_ID")
	private String nationalID;

	@Column(name = "Country")
	private String country;

	@Column(name = "Office")
	private String office;

	@Column(name = "Duty")
	private String duty;
//	======================One To Many=========================

	@OneToMany(mappedBy = "employeeID")
	private List<HistoryOff> HistoryOffID;

	@OneToMany(mappedBy = "senderEmp", cascade = CascadeType.REMOVE)
	private List<Receiver> senderEmp;

	@OneToMany(mappedBy = "receiverEmp", cascade = CascadeType.REMOVE)
	private List<Receiver> receiverEmp;

	@OneToMany(mappedBy = "participantEmp", cascade = CascadeType.REMOVE)
	private List<Participants> participantEmp;

//	======================Many To Many==============================

	@OneToMany(mappedBy = "employeeID")
	private Set<EmployeeWork> employeeWork;

//	====================================================
	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getNationalID() {
		return nationalID;
	}

	public void setNationalID(String nationalID) {
		this.nationalID = nationalID;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public List<HistoryOff> getHistoryOffID() {
		return HistoryOffID;
	}

	public void setHistoryOffID(List<HistoryOff> historyOffID) {
		HistoryOffID = historyOffID;
	}

	public Set<EmployeeWork> getEmployeeWork() {
		return employeeWork;
	}

	public void setEmployeeWork(Set<EmployeeWork> employeeWork) {
		this.employeeWork = employeeWork;
	}

	public List<Receiver> getSenderEmp() {
		return senderEmp;
	}

	public void setSenderEmp(List<Receiver> senderEmp) {
		this.senderEmp = senderEmp;
	}

	public List<Receiver> getReceiverEmp() {
		return receiverEmp;
	}

	public void setReceiverEmp(List<Receiver> receiverEmp) {
		this.receiverEmp = receiverEmp;
	}

	public List<Participants> getParticipantEmp() {
		return participantEmp;
	}

	public void setParticipantEmp(List<Participants> participantEmp) {
		this.participantEmp = participantEmp;
	}

	// ============================================================
	public Employee() {
		super();
	}

	public Employee(String employeeID, String fullName, String gender, String phoneNumber, LocalDate dateOfBirth,
			String nationalID, String country, String office, String duty, List<HistoryOff> historyOffID,
			Employee manager, List<Employee> under, Set<EmployeeWork> employeeWork) {
		super();
		this.employeeID = employeeID;
		this.fullName = fullName;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.nationalID = nationalID;
		this.country = country;
		this.office = office;
		this.duty = duty;
		HistoryOffID = historyOffID;
		this.employeeWork = employeeWork;
	}

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", fullName=" + fullName + ", gender=" + gender + ", phoneNumber="
				+ phoneNumber + ", dateOfBirth=" + dateOfBirth + ", nationalID=" + nationalID + ", country=" + country
				+ ", office=" + office + ", duty=" + duty + ", HistoryOffID=" + HistoryOffID + ", manager=" + ", under="
				+ ", employeeWork=" + employeeWork + "]";
	}

}