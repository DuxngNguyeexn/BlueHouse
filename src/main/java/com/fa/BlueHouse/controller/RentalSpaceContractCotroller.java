package com.fa.BlueHouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.fa.BlueHouse.entities.RentalSpaceContract;
import com.fa.BlueHouse.services.RentalSpaceContractService;

@Controller
public class RentalSpaceContractCotroller {

	@Autowired
	private RentalSpaceContractService rentalSpaContrac;
	
	@GetMapping("/createrentalspacon")
	public String createRentalSpaContrac(Model model) {
		model.addAttribute("listRentalSpa", rentalSpaContrac.findalRenSpaCon());
		return "/AddRentalSpaceContract";
	}
	
	@PostMapping("/addrenspacon")
	public String saveRentalSpaContrac(Model model, @ModelAttribute RentalSpaceContract rentalSpaCon) {
		rentalSpaContrac.saveRentalSpaceContractDao(rentalSpaCon);
		return "/AddRentalSpaceContract";
	}
}
