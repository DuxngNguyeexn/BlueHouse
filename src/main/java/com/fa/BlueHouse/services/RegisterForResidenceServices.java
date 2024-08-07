package com.fa.BlueHouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fa.BlueHouse.entities.Apartment;
import com.fa.BlueHouse.entities.RegisterForResidence;
import com.fa.BlueHouse.entities.Resident;
import com.fa.BlueHouse.repositories.ApartmentRepository;
import com.fa.BlueHouse.repositories.RegisterForResidenceRepository;
import com.fa.BlueHouse.repositories.ResidentRepositories;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RegisterForResidenceServices {

	@Autowired
	private RegisterForResidenceRepository regiresirepository;
	
	@Autowired 
	private ApartmentRepository apartmentRepository;
	
	@Autowired
	private ResidentRepositories residentRepositories;
	
	public void saveRegisterForResidence(RegisterForResidence registerForResidence) {
		regiresirepository.save(registerForResidence);
	}
	
	public List<RegisterForResidence> findaRegiResi(){
		return regiresirepository.findAll();
	}
	
	public List<Apartment> findaApa(){
		return apartmentRepository.findAll();
	}
	
	public List<Resident> findaResident(){
		return residentRepositories.findAll();
	}
	
	
	public RegisterForResidence findaById(String id) {
		return regiresirepository.findById(id).orElse(null);
	}
	
	public void deleteRegisterResi(String id) {
		regiresirepository.deleteById(id);
	}
	
	public void  updateRegisterResi(RegisterForResidence registerForResidence) {
		regiresirepository.save(registerForResidence);
	}
	
	public Page<RegisterForResidence> allRegisterForResidence(Pageable pageable){
		return regiresirepository.findAll(pageable);
	}
	public Page<RegisterForResidence> seachRegisterForResidence(Pageable pageable, String search){
		return regiresirepository.searchRegisterForResidence(search, pageable);
	}
	
}
