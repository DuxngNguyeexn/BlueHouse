package com.fa.BlueHouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fa.BlueHouse.entities.Apartment;
import com.fa.BlueHouse.entities.Employee;
import com.fa.BlueHouse.entities.RentalSpaceContract;
import com.fa.BlueHouse.repositories.ApartmentDao;
import com.fa.BlueHouse.repositories.EmployeeDao;
import com.fa.BlueHouse.repositories.RentalSpaceContractDao;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RentalSpaceContractService {

	@Autowired
	private RentalSpaceContractDao renSpaCon;
	
	@Autowired
	private ApartmentDao apartment;
	
	@Autowired 
	private EmployeeDao employee;
	
	public void saveRentalSpaceContractDao(RentalSpaceContract renspa) {
		renSpaCon.save(renspa);
	}
	
	public List<Employee> findalEmploy(){
		return employee.findAll();
	}
	public List<RentalSpaceContract> findalRenSpaCon(){
		return renSpaCon.findAll();
	}
	
	public List<Apartment> findalApa(){
		return apartment.findAll();
	}
	
<<<<<<< HEAD
	public void deleteRentalSpacon( String id) {
		renSpaCon.deleteById(id);
	}
	 public RentalSpaceContract findById(String id) {
		 return renSpaCon.findById(id).orElse(null);
	 }
	public void updateRenSpaCon(RentalSpaceContract renspa) {
		renSpaCon.save(renspa);
=======
	public RentalSpaceContract findByID(String id) {
		return renSpaCon.findById(id).orElse(null);
	}
	
	public void deleteRenSapCon(String id) {
		renSpaCon.deleteById(id);
	}
	
	public void updateRenSpaCon(RentalSpaceContract rentalSpaCon) {
		renSpaCon.save(rentalSpaCon);
>>>>>>> tienmanh
	}
}
