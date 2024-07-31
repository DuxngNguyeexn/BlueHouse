package com.fa.BlueHouse.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

	@Id
	private String IdEmployee ;
	
	@OneToMany(mappedBy = "Manager_CodeRegi")
	List<Register_For_Residence> register_For_Residences;

	@OneToMany(mappedBy = "Manager_codeContract")
	List<Rental_space_contract> rental_space_contractsEMP;
	
	@OneToMany(mappedBy = "Manager_codeTransfer")
	List<Apartment_Transfer_History> apartment_Transfer_HistoriesEMP;
	public Employee() {
		super();
	}
	
}
