package com.fa.BlueHouse.entities;

import java.util.List;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Assets {
	@EmbeddedId
	IdAssets id;
	String name;
	
	int quantityOfAssets;
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