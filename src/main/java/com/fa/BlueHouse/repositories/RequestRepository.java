package com.fa.BlueHouse.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fa.BlueHouse.entities.form.Request;

public interface RequestRepository extends JpaRepository<Request, String>{
	 @Query("SELECT MAX(r.id) FROM Request r")
	    String findMaxId();
	 @Query("FROM Request r WHERE r.repair.employee.employeeID = :id")
	 Page<Request> findRequestByEmployeeId(@Param("id") String id , Pageable pageable );
	 
	 @Query("FROM Request r WHERE r.resident.idResident = :id")
	 Page<Request> findRequestByResidentId(@Param("id") String id , Pageable pageable );
}
