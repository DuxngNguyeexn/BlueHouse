package com.fa.BlueHouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fa.BlueHouse.entities.Position;

public interface PositionRepositories extends JpaRepository<Position, String> {

}
