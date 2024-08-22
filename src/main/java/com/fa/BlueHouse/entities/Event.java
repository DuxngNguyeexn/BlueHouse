package com.fa.BlueHouse.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Event {
	@Id
	@Column(name = "ID_Event")
	String idEvent;

	@Column(name = "name_Event")
	String nameEvent;

	@Column(name = "start_Date")
	LocalDate startDate;
	@Column(name = "end_Date")
	LocalDate endDate;

	@Column(name = "start_Time")
	LocalTime startTime;
	@Column(name = "end_Time")
	LocalTime endTime;

	@Column(name = "location")
	String location;

	@Column(name = "Count_Participants")
	int numberOfParticipants;

	@OneToOne
	@JoinColumn(name = "Bill")
	private ExpenseBill bill;

	@ManyToOne
	@JoinColumn(name = "ID_Oganizer")
	private Resident IDOganizer;

	@OneToMany(mappedBy = "IDEvent")
	private List<Participants> listParticipants;

	public String getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(String idEvent) {
		this.idEvent = idEvent;
	}

	public String getNameEvent() {
		return nameEvent;
	}

	public void setNameEvent(String nameEvent) {
		this.nameEvent = nameEvent;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getNumberOfParticipants() {
		return numberOfParticipants;
	}

	public void setNumberOfParticipants(int numberOfParticipants) {
		this.numberOfParticipants = numberOfParticipants;
	}

	public ExpenseBill getBill() {
		return bill;
	}

	public void setBill(ExpenseBill bill) {
		this.bill = bill;
	}

	public Resident getIDOganizer() {
		return IDOganizer;
	}

	public void setIDOganizer(Resident iDOganizer) {
		IDOganizer = iDOganizer;
	}

	public List<Participants> getListParticipants() {
		return listParticipants;
	}

	public void setListParticipants(List<Participants> listParticipants) {
		this.listParticipants = listParticipants;
	}

	public Event() {
		super();
	}

	public Event(String idEvent, String nameEvent, LocalDate startDate, LocalDate endDate, LocalTime startTime,
			LocalTime endTime, String location, int numberOfParticipants) {
		super();
		this.idEvent = idEvent;
		this.nameEvent = nameEvent;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.location = location;
		this.numberOfParticipants = numberOfParticipants;
	}

	@Override
	public String toString() {
		return "Event [idEvent=" + idEvent + ", nameEvent=" + nameEvent + ", startDate=" + startDate + ", endDate="
				+ endDate + ", startTime=" + startTime + ", endTime=" + endTime + ", location=" + location
				+ ", numberOfParticipants=" + numberOfParticipants + ", bill=" + bill + ", IDOganizer=" + IDOganizer
				+ ", listParticipants=" + listParticipants + "]";
	}

}
