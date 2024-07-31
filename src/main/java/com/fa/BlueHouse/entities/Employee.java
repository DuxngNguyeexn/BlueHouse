package com.fa.BlueHouse.entities;

import java.util.Date;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
	@Id
	String id;
	
	String name;
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	Date dob;
	String office;
	String phoneNumber;
	String nationalId;
	String country;
	String sex;
	String position;
	
	public Employee() {
		super();
	}
	public Employee(String idEmployee, String nameEmployee, Date dob, String office, String phoneNumber,
			String nationalId, String country, String sex, String position) {
		super();
		this.id = idEmployee;
		this.name = nameEmployee;
		this.dob = dob;
		this.office = office;
		this.phoneNumber = phoneNumber;
		this.nationalId = nationalId;
		this.country = country;
		this.sex = sex;
		this.position = position;
	}
	public String getIdEmployee() {
		return id;
	}
	public void setIdEmployee(String idEmployee) {
		this.id = idEmployee;
	}
	public String getNameEmployee() {
		return name;
	}
	public void setNameEmployee(String nameEmployee) {
		this.name = nameEmployee;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getNationalId() {
		return nationalId;
	}
	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	@Override
	public int hashCode() {
		return Objects.hash(country, dob, id, name, nationalId, office, phoneNumber, position, sex);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(country, other.country) && Objects.equals(dob, other.dob)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(nationalId, other.nationalId) && Objects.equals(office, other.office)
				&& Objects.equals(phoneNumber, other.phoneNumber) && Objects.equals(position, other.position)
				&& Objects.equals(sex, other.sex);
	}
	
	
}
