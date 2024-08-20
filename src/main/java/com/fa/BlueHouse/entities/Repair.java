package com.fa.BlueHouse.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Repair {
	@Id
	private String id;
	
	@OneToOne
	private Assets asset;
	
	@OneToOne
	private ExpenseBillDetail expenseBillDetail;
	
	@ManyToOne
	private Employee employee;
	
	Date dateRepair;
	Date dateCompleted;
	private String imagePath;
	
	public Repair() {
		super();
	}

	public Repair(String id, Assets asset, ExpenseBillDetail expenseBillDetail, Date dateRepair , Employee employee ,String imagePath) {
		super();
		this.id = id;
		this.asset = asset;
		this.expenseBillDetail = expenseBillDetail;
		this.dateRepair = dateRepair;
		this.employee = employee;
		this.imagePath= imagePath;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Assets getAsset() {
		return asset;
	}

	public void setAsset(Assets asset) {
		this.asset = asset;
	}

	public ExpenseBillDetail getExpenseBillDetail() {
		return expenseBillDetail;
	}

	public void setExpenseBillDetail(ExpenseBillDetail expenseBillDetail) {
		this.expenseBillDetail = expenseBillDetail;
	}

	public Date getDateRepair() {
		return dateRepair;
	}

	public void setDateRepair(Date dateRepair) {
		this.dateRepair = dateRepair;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getDateCompleted() {
		return dateCompleted;
	}

	public void setDateCompleted(Date dateCompleted) {
		this.dateCompleted = dateCompleted;
	}
	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	
}
