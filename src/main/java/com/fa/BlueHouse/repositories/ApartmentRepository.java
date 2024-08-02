package com.fa.BlueHouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fa.BlueHouse.entities.Apartment;
public interface ApartmentRepository extends JpaRepository<Apartment, String> {

}
