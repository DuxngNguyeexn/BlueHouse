package com.fa.BlueHouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fa.BlueHouse.authen.model.Account;

public interface AccountRepo extends JpaRepository<Account, String>{

}
