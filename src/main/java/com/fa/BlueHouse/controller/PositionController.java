package com.fa.BlueHouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.fa.BlueHouse.services.PositionService;

@Controller
public class PositionController {

	@Autowired
	private PositionService position;
	
}
