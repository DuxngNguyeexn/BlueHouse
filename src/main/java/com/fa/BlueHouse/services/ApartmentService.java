package com.fa.BlueHouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fa.BlueHouse.entities.Apartment;
import com.fa.BlueHouse.repositories.ApartmentRepository;

@Service

public class ApartmentService {
	@Autowired
	ApartmentRepository apartmentRepository;
	
	public List<Apartment> allApartments(){
		return apartmentRepository.findAll();
	}
}
