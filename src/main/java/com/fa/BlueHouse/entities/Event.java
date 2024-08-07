package com.fa.BlueHouse.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Event {
	@Id
	String idEvent;
	
	String nameEvent;
	
	Date startDate;
	Date endDate;
	
	String location;
	
	int numberOfParticipants;

	
	public Event() {
		super();
	}

	public Event(String idEvent, String nameEvent, Date startDate, Date endDate, String location,
			int numberOfParticipants) {
		super();
		this.idEvent = idEvent;
		this.nameEvent = nameEvent;
		this.startDate = startDate;
		this.endDate = endDate;
		this.location = location;
		this.numberOfParticipants = numberOfParticipants;
	}

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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
	
}
