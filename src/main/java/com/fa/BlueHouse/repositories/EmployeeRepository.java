package com.fa.BlueHouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fa.BlueHouse.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String>{

}
