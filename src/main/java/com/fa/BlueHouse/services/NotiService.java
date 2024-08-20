package com.fa.BlueHouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fa.BlueHouse.entities.Notification;
import com.fa.BlueHouse.entities.Receiver;
import com.fa.BlueHouse.repositories.NotiRepositories;
import com.fa.BlueHouse.repositories.ReceiverRepositories;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class NotiService {
	
	@Autowired
	private NotiRepositories notiRepo;
	
	@Autowired
	private ReceiverRepositories receiRepo;
	
	public void saveNoti(Notification noti) {
		notiRepo.save(noti);
	}
	
	public void saveRecei(Receiver recei) {
		receiRepo.save(recei);
	}
	
	public List<Notification> findByIDSend(String id) {
		return receiRepo.findByIDSend(id);
	}

}
