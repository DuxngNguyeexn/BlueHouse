package com.fa.BlueHouse.sevices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fa.BlueHouse.entities.Position;
import com.fa.BlueHouse.repositories.PositionRepositories;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PositionService {

	@Autowired
	private PositionRepositories position;
	
	public void savePosition(Position posi) {
		position.save(posi);
	}
	
	public void deletePosition(Position posi) {
		position.delete(posi);
	}
	
	public Position findById(String id) {
		return position.findById(id).orElse(null);
	}
	
	public List<Position> findall(){
		return position.findAll();
	}
	
}
