package com.fa.BlueHouse.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class IncomeBillDetail {
	@Id
	private String idbilldetail;
	@ManyToOne
	private IncomeBill idIncomeBill;
	@ManyToOne
	private FeeType idfeetype;
	private float quantity;
	private float price;

	public String getIdbilldetail() {
		return idbilldetail;
	}

	public void setIdbilldetail(String idbilldetail) {
		this.idbilldetail = idbilldetail;
	}

	public IncomeBill getIdIncomeBill() {
		return idIncomeBill;
	}

	public void setIdIncomeBill(IncomeBill idIncomeBill) {
		this.idIncomeBill = idIncomeBill;
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

	public IncomeBillDetail() {
		super();
	}

	public FeeType getIdfeetype() {
		return idfeetype;
	}

	public void setIdfeetype(FeeType idfeetype) {
		this.idfeetype = idfeetype;
	}

	public IncomeBillDetail(String idbilldetail, IncomeBill idIncomeBill, FeeType idfeetype, float quantity,
			float price) {
		super();
		this.idbilldetail = idbilldetail;
		this.idIncomeBill = idIncomeBill;
		this.idfeetype = idfeetype;
		this.quantity = quantity;
		this.price = price;
	}

	@Override
	public String toString() {
		return "BillDetail [getIdbilldetail()=" + getIdbilldetail() + ", getQuantity()=" + getQuantity()
				+ ", getPrice()=" + getPrice() + "]";
	}

}
