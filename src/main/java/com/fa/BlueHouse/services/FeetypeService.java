package com.fa.BlueHouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fa.BlueHouse.entities.FeeType;
import com.fa.BlueHouse.repositories.FeetypeRepositories;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FeetypeService {

	@Autowired
	private FeetypeRepositories feetype;
	public List<FeeType> findallFeetype(){
		return feetype.findAll();
	}
	public Page<FeeType> findallpageFeetype(Pageable page){
		return feetype.findAll(page);
	}
	
	public void saveFeetype(FeeType fee) {
		feetype.save(fee);
	}
	public FeeType findById(String id) {
		return feetype.findById(id).orElse(null);
	}
}
