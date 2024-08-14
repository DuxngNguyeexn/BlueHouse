package com.fa.BlueHouse.entities;

import java.util.List;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Assets {
	@Valid
	@EmbeddedId
	IdAssets id;
	@NotEmpty(message = "Please enter name assets")
	String name;
	@Min(value = 1, message = "Invalid number of assets. Minimum should be 1.")
	int quantityOfAssets;
	@Min(value = 1000, message = "Invalid price of assets. Minimum should be 1000.")
	long priceOfAssets;
	
	@ManyToOne
	Employee employ;
	
	@OneToMany(mappedBy = "asset")	
	List<Schedules> schedules ;
	public Assets() {
		super();
	}
	
	
	public Assets(IdAssets id, String name, int quantityOfAssets, long priceOfAssets, Employee employ,
			List<Schedules> schedules) {
		super();
		this.id = id;
		this.name = name;
		this.quantityOfAssets = quantityOfAssets;
		this.priceOfAssets = priceOfAssets;
		this.employ = employ;
		this.schedules = schedules;
	}


	public IdAssets getId() {
		return id;
	}
	public void setId(IdAssets id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantityOfAssets() {
		return quantityOfAssets;
	}
	public void setQuantityOfAssets(int quantityOfAssets) {
		this.quantityOfAssets = quantityOfAssets;
	}
	public long getPriceOfAssets() {
		return priceOfAssets;
	}
	public void setPriceOfAssets(long priceOfAssets) {
		this.priceOfAssets = priceOfAssets;
	}
	public Employee getEmploy() {
		return employ;
	}
	public void setEmploy(Employee employ) {
		this.employ = employ;
	}
	public List<Schedules> getSchedules() {
		return schedules;
	}
	public void setSchedules(List<Schedules> schedules) {
		this.schedules = schedules;
	}

	
}