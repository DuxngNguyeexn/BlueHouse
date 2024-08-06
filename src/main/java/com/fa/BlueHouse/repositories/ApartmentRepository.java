package com.fa.BlueHouse.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fa.BlueHouse.entities.Apartment;
public interface ApartmentRepository extends JpaRepository<Apartment, String> {

	@Query("SELECT a FROM Apartment a WHERE a.idApartment LIKE %:keyword% ")
	Page<Apartment> findApartmentByKeyword(@Param("keyword") String keyword , Pageable pageable);
}
