package com.fa.BlueHouse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fa.BlueHouse.repositories.ExpenseBillDetailRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ExpenseBillDetailService {

	@Autowired
	private ExpenseBillDetailRepository expendetail;
}
