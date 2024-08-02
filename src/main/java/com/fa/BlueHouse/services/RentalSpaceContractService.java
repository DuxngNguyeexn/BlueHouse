package com.fa.BlueHouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fa.BlueHouse.entities.RentalSpaceContract;
import com.fa.BlueHouse.repositorys.RentalSpaceContractDao;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RentalSpaceContractService {

	@Autowired
	private RentalSpaceContractDao renSpaCon;
	
	public void saveRentalSpaceContractDao(RentalSpaceContract renspa) {
		renSpaCon.save(renspa);
	}
	
	public List<RentalSpaceContract> findalRenSpaCon(){
		return renSpaCon.findAll();
	}
	
}
