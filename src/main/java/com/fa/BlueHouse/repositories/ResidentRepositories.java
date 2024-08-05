package com.fa.BlueHouse.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fa.BlueHouse.entities.Resident;

public interface ResidentRepositories extends JpaRepository<Resident, String> {
	
	@Query("FROM Resident where nameResident=?1 or gender=?1 or relationshipHousehold=?1 or phonenumber=?1 or workplace=?1 or identificationCard=?1")
	public List<Resident> searchResident(String seacrch);

}
