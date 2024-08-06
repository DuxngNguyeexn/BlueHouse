package com.fa.BlueHouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fa.BlueHouse.entities.Apartment;
import com.fa.BlueHouse.entities.Resident;
import com.fa.BlueHouse.repositories.ApartmentRepository;
import com.fa.BlueHouse.repositories.ResidentRepositories;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class ResidentService {
	@Autowired
	private ResidentRepositories repositori;
	@Autowired
	private ApartmentRepository apart;
	
	public void saveResident(Resident resi) {
		repositori.save(resi);
	}
	
	public List<Resident> findallResident(){
		return repositori.findAll();
	}

    public List<Resident> searchResident(String search){
    	return repositori.searchResident(search);
    }
    
    public List<Apartment> findallapart(){
    	return apart.findAll();
    }
    
    public void deleteResident(String id) {
    	repositori.deleteById(id);
    }
    public void updateResident(Resident resi) {
    	repositori.save(resi);
    }
    
    public Resident findById(String id) {
    	return repositori.findById(id).orElse(null);
    }
}
