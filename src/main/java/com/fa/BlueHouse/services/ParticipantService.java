package com.fa.BlueHouse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fa.BlueHouse.entities.Participants;
import com.fa.BlueHouse.repositories.ParticipantRepo;

@Service
public class ParticipantService {
	
	@Autowired
	private ParticipantRepo partiRepo;
	
	public void saveParticipant(Participants par) {
		partiRepo.save(par);
	}

}
