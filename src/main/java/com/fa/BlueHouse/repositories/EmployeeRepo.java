package com.fa.BlueHouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fa.BlueHouse.entities.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, String>{

}
