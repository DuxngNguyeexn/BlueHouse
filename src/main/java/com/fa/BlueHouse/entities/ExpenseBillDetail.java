package com.fa.BlueHouse.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ExpenseBillDetail {
	@Id
	private String idexpenDetail;
	@ManyToOne
	private ExpenseBill idExpenseBill;
	private String nameExpense;
	private float quantity;
	private float price;
	public ExpenseBillDetail() {
		super();
	}

	public ExpenseBillDetail(String idexpenDetail, ExpenseBill idExpenseBill, String nameExpense, float quantity,
			float price) {
		super();
		this.idexpenDetail = idexpenDetail;
		this.idExpenseBill = idExpenseBill;
		this.nameExpense = nameExpense;
		this.quantity = quantity;
		this.price = price;
	}

	public String getIdexpenDetail() {
		return idexpenDetail;
	}

	public void setIdexpenDetail(String idexpenDetail) {
		this.idexpenDetail = idexpenDetail;
	}

	public ExpenseBill getIdExpenseBill() {
		return idExpenseBill;
	}

	public void setIdExpenseBill(ExpenseBill idExpenseBill) {
		this.idExpenseBill = idExpenseBill;
	}

	public String getNameExpense() {
		return nameExpense;
	}

	public void setNameExpense(String nameExpense) {
		this.nameExpense = nameExpense;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ExpenseBillDetail [getIdexpenDetail()=" + getIdexpenDetail() + ", getNameExpense()=" + getNameExpense()
				+ ", getQuantity()=" + getQuantity() + ", getPrice()=" + getPrice() + "]";
	}

}
