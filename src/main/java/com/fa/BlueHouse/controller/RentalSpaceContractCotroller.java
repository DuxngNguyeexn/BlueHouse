package com.fa.BlueHouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fa.BlueHouse.entities.RentalSpaceContract;
import com.fa.BlueHouse.services.RentalSpaceContractService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class RentalSpaceContractCotroller {

	@Autowired
	private RentalSpaceContractService rentalSpaContrac;

	@GetMapping("/createrentalSpaContracs")
	public String createRentalSpaContrac(Model model) {
		model.addAttribute("RentalSpa", new RentalSpaceContract ());
		model.addAttribute("apartments", rentalSpaContrac.findalApa());
		model.addAttribute("employees", rentalSpaContrac.findalEmploy());
		return "/AddRentalSpaceContract";
	}
	
	@PostMapping("/saverentalSpaContracs")
	public String saveRentalSpaContrac(Model model,@ModelAttribute RentalSpaceContract rentalSpaCon) {
		rentalSpaContrac.saveRentalSpaceContractDao(rentalSpaCon);
		return "redirect:/showrentalSpaContracs";
	}
	
	@GetMapping("/showrentalSpaContracs")
	public String showListRentalSpaCon(Model model) {
		model.addAttribute("listRentalSpa", rentalSpaContrac.findalRenSpaCon());
		return "/listRentalSpaContrac";
	}
	
<<<<<<< HEAD
	@GetMapping("/deleteRentalcon")
	public String deleteRentalSpaCon(@RequestParam("id") String id) {
		rentalSpaContrac.deleteRentalSpacon(id);
		return "redirect:/showrentalSpaContracs";
	}
	
	@GetMapping("/editrentalSpaContracs")
	public String editRentalSpaContrac(Model model, @RequestParam("id") String id) {
		RentalSpaceContract renSpaCon = rentalSpaContrac.findById(id);
		model.addAttribute("renspacon", renSpaCon);
		model.addAttribute("apartments", rentalSpaContrac.findalApa());
		model.addAttribute("employees", rentalSpaContrac.findalEmploy());
		return "/AddRentalSpaceContract";
	}
	@PostMapping("/updaterentalSpaContracs")
	public String updateRentalSpaContrac(@ModelAttribute("RentalSpa") RentalSpaceContract rentalSpaCon) {
		rentalSpaContrac.updateRenSpaCon(rentalSpaCon);
=======
	@GetMapping("/deleterenspacon")
	public String deleteRenSpaCon(@RequestParam("idrenspacon") String id) {
		rentalSpaContrac.deleteRenSapCon(id);
		return "redirect:/showrentalSpaContracs";
	}

	@GetMapping("/editrenspacon")
	public String editRenSpaCon(Model model, @RequestParam("idrenspacon") String id) {
		List<RentalSpaceContract> listresi = rentalSpaContrac.findalRenSpaCon();
		model.addAttribute("listapartment", listresi);
		model.addAttribute("renspacont", rentalSpaContrac.findByID(id));
		return "updateRenSpaCon";
	}
	@PostMapping("/saveupdaterenspacon")
	public String saveupdateRenSpaCon(@ModelAttribute("idrenspacon") RentalSpaceContract renspa) {
		rentalSpaContrac.updateRenSpaCon(renspa);
>>>>>>> tienmanh
		return "redirect:/showrentalSpaContracs";
	}
}
