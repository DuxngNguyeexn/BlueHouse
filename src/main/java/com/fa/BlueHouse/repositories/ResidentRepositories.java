package com.fa.BlueHouse.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fa.BlueHouse.entities.Resident;

public interface ResidentRepositories extends JpaRepository<Resident, String> {
	
	@Query("FROM Resident where nameResident LIKE %:seacrch% or gender LIKE %:seacrch% or relationshipHousehold LIKE %:seacrch% or phonenumber LIKE %:seacrch% or workplace LIKE %:seacrch% or identificationCard LIKE %:seacrch%")
	public List<Resident> searchResident(String seacrch);

	public List<Resident> findByIdApartment_idApartment(String idApartment) ;

}
