package com.fa.BlueHouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fa.BlueHouse.entities.IncomeBill;
import com.fa.BlueHouse.repositories.IncomeBillRepositories;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class IncomeBillService {

	@Autowired
	private IncomeBillRepositories inbill;
	
	public Page<IncomeBill> findApartmentBill(String idApartment, Pageable page){
		return inbill.findApartmentBill(idApartment, page);
	}
	
	public void saveIncobill(IncomeBill inco) {
		inbill.save(inco);
	}
	public Page<IncomeBill> findAllbill(Pageable page){
		return inbill.findAll(page);
	}
	public Page<IncomeBill> searchIncomeBill(String search, Pageable page){
		return inbill.searchInBill(search, page);
	}
	public IncomeBill findById(String id) {
		return inbill.findById(id).orElse(null);
	}
	public List<IncomeBill> finall(){
		return inbill.findAll();
	}
	public String generateNewId() {
		String maxId = inbill.findMaxId();
		
		if(maxId == null) return "IB001";
		
		int numberic = Integer.parseInt(maxId.substring(2));
		
		numberic++;
		
		return String.format("IB%03d", numberic);
	}
}
