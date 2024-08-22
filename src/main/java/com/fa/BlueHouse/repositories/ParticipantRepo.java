package com.fa.BlueHouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fa.BlueHouse.entities.Participants;

public interface ParticipantRepo extends JpaRepository<Participants, Integer> {

}
