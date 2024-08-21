package com.fa.BlueHouse.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Repair {
	@Id
	private String id;

	@OneToMany(mappedBy = "repair", cascade = CascadeType.ALL)
	private List<Assets> assets;

	@OneToOne
	private ExpenseBillDetail expenseBillDetail;

	@ManyToOne
	private Employee employee;
	Date dateAssign;
	Date dateRepair;
	Date dateCompleted;
	private String imagePath;

	public Repair() {
		super();
	}

	public Repair(String id, List<Assets> assets, ExpenseBillDetail expenseBillDetail, Employee employee,
			Date dateAssign, Date dateRepair, Date dateCompleted, String imagePath) {
		super();
		this.id = id;
		this.assets = assets;
		this.expenseBillDetail = expenseBillDetail;
		this.employee = employee;
		this.dateAssign = dateAssign;
		this.dateRepair = dateRepair;
		this.dateCompleted = dateCompleted;
		this.imagePath = imagePath;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Assets> getAssets() {
		return assets;
	}

	public void setAssets(List<Assets> assets) {
		this.assets = assets;
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

	public Date getDateAssign() {
		return dateAssign;
	}

	public void setDateAssign(Date dateAssign) {
		this.dateAssign = dateAssign;
	}

}
