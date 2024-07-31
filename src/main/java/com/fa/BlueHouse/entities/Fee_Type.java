package com.fa.BlueHouse.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "FEE_TYPE")
public class Fee_Type {

	@Id
	private String Fee_Type_Code;
	
	@OneToMany(mappedBy = "Fee_type_code")
	List<Vehicle_Registration> vehicle_RegistrationsFEE;

	public Fee_Type() {
		super();
	}
	
	
}
