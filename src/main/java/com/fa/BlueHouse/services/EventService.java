package com.fa.BlueHouse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fa.BlueHouse.entities.Event;
import com.fa.BlueHouse.repositories.EventRepositories;

@Service
public class EventService {
	@Autowired
	private EventRepositories eventRepo;

	public void saveEvent(Event event) {
		eventRepo.save(event);
	}

	public Page<Event> getAllEvent(String idResi, Pageable pageable) {
		return eventRepo.getAllEvent(idResi, pageable);
	}
	
	public Event findById(String id) {
    	return eventRepo.findById(id).orElse(null);
    }
	
	public void deleteById(String eventID) {
		eventRepo.deleteById(eventID);
	}

}
