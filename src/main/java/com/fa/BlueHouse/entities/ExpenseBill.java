package com.fa.BlueHouse.entities;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class ExpenseBill {
	@Id
	private String idExpenseBill;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate expenseDate;
	@ManyToOne
	private Administrators idAdministrators;
	@OneToMany(mappedBy = "idExpenseBill")
	private List<ExpenseBillDetail> listExpenDetail;
	private float totalprice;

	public String getIdExpenseBill() {
		return idExpenseBill;
	}

	public void setIdExpenseBill(String idExpenseBill) {
		this.idExpenseBill = idExpenseBill;
	}

	public LocalDate getExpenseDate() {
		return expenseDate;
	}

	public void setExpenseDate(LocalDate expenseDate) {
		this.expenseDate = expenseDate;
	}

	public Administrators getIdAdministrators() {
		return idAdministrators;
	}

	public void setIdAdministrators(Administrators idAdministrators) {
		this.idAdministrators = idAdministrators;
	}

	public List<ExpenseBillDetail> getListExpenDetail() {
		return listExpenDetail;
	}

	public void setListExpenDetail(List<ExpenseBillDetail> listExpenDetail) {
		this.listExpenDetail = listExpenDetail;
	}

	public float getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
	}

	public ExpenseBill(String idExpenseBill, LocalDate expenseDate, Administrators idAdministrators,
			List<ExpenseBillDetail> listExpenDetail, float totalprice) {
		super();
		this.idExpenseBill = idExpenseBill;
		this.expenseDate = expenseDate;
		this.idAdministrators = idAdministrators;
		this.listExpenDetail = listExpenDetail;
		this.totalprice = totalprice;
	}

	public ExpenseBill() {
		super();
	}

	@Override
	public String toString() {
		return "ExpenseBill [getIdExpenseBill()=" + getIdExpenseBill() + ", getExpenseDate()=" + getExpenseDate()
				+ ", getTotalprice()=" + getTotalprice() + "]";
	}

}
