package com.fa.BlueHouse.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fa.BlueHouse.entities.Event;

public interface EventRepositories extends JpaRepository<Event, String> {

	@Query("SELECT e FROM Event e WHERE e.IDOganizer.idResident = :idResi ")
	Page<Event> getAllEvent(@Param("idResi") String idResi, Pageable pageable);
	
}
