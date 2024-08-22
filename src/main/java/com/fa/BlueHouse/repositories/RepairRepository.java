package com.fa.BlueHouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fa.BlueHouse.entities.Repair;

public interface RepairRepository extends JpaRepository<Repair, String> {
	@Query("SELECT MAX(r.id) FROM Repair r")
    String findMaxId();
}
