package com.fa.BlueHouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fa.BlueHouse.entities.Employee;
import com.fa.BlueHouse.repositories.EmployeeRepo;

@Service
public class EmployeeService {
	  @Autowired
	  EmployeeRepo employeeRepo;
	  
	  public List<Employee> listAdministrator(){
		  return employeeRepo.findAdministrator();
	  }
}
