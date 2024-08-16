package com.fa.BlueHouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fa.BlueHouse.entities.form.Request;

public interface RequestRepository extends JpaRepository<Request, String>{
	 @Query("SELECT MAX(r.id) FROM Request r")
	    String findMaxId();
}
