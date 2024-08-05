package com.fa.BlueHouse.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fa.BlueHouse.entities.Employee;

public interface EmployeeDao extends JpaRepository<Employee, String>{

}
