package com.fa.BlueHouse.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fa.BlueHouse.entities.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, String>{
	@Query("SELECT e FROM Employee e WHERE e.duty = 'Administrator'")
	List<Employee> findAdministrator();
}
