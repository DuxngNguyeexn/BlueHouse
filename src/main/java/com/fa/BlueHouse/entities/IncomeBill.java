package com.fa.BlueHouse.entities;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class IncomeBill {
	@Id
	private String idIncomeBill;
	@OneToOne
	private Apartment idApartment;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate billDate;
	private LocalDate paymentDate;
	private String status;
	private float total;
	@OneToMany(mappedBy = "idIncomeBill")
	private List<IncomeBillDetail> listdetail;
	public IncomeBill(String idIncomeBill, Apartment idApartment, LocalDate billDate, LocalDate paymentDate,
			String status, float total) {
		super();
		this.idIncomeBill = idIncomeBill;
		this.idApartment = idApartment;
		this.billDate = billDate;
		this.paymentDate = paymentDate;
		this.status = status;
		this.total = total;
	}
	public IncomeBill() {
		super();
	}
	
	public List<IncomeBillDetail> getListdetail() {
		return listdetail;
	}
	public void setListdetail(List<IncomeBillDetail> listdetail) {
		this.listdetail = listdetail;
	}
	public String getIdIncomeBill() {
		return idIncomeBill;
	}
	public void setIdIncomeBill(String idIncomeBill) {
		this.idIncomeBill = idIncomeBill;
	}
	public Apartment getIdApartment() {
		return idApartment;
	}
	public void setIdApartment(Apartment idApartment) {
		this.idApartment = idApartment;
	}
	public LocalDate getBillDate() {
		return billDate;
	}
	public void setBillDate(LocalDate billDate) {
		this.billDate = billDate;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "IncomeBill [getIdIncomeBill()=" + getIdIncomeBill() + ", getBillDate()=" + getBillDate()
				+ ", getPaymentDate()=" + getPaymentDate() + ", getStatus()=" + getStatus() + ", getTotal()="
				+ getTotal() + "]";
	}
	
	
}
