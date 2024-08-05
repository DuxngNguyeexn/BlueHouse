package com.fa.BlueHouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fa.BlueHouse.entities.Apartment;

public interface ApartmentDao extends JpaRepository<Apartment, String>{

}
