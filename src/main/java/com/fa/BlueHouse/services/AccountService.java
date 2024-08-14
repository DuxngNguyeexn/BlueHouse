package com.fa.BlueHouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fa.BlueHouse.authen.model.Account;
import com.fa.BlueHouse.repositories.AccountRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AccountService {
	
	@Autowired
	private AccountRepo aRepo;
	
	public List<Account> allAccount() {
		return aRepo.findAll();
	}

}
