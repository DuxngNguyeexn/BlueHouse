package com.fa.BlueHouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fa.BlueHouse.entities.Apartment;
import com.fa.BlueHouse.services.ApartmentService;

@Controller
@RequestMapping(path = "/apartment/")
public class ApartmentController {
	@Autowired
	ApartmentService apartmentService;
	@GetMapping("/")
	public String showAll(Model model) {
		List<Apartment> allApartments = apartmentService.allApartments();
		model.addAttribute("listApartmnet", allApartments);
		return "Apartment/list";
	}
}
