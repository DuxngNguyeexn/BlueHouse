package com.fa.BlueHouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fa.BlueHouse.entities.Employee;
import com.fa.BlueHouse.repositories.EmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo eRepo;
	
	public List<Employee> allEmployee(){
		return eRepo.findAll();
	}
	
	public Page<Employee> allEmployee(Pageable pageable){
		return eRepo.findAll(pageable);
	}

}
