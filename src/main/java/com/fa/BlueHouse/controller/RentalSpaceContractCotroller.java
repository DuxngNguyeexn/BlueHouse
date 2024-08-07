package com.fa.BlueHouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.fa.BlueHouse.entities.RentalSpaceContract;
import com.fa.BlueHouse.services.RentalSpaceContractService;

import jakarta.validation.Valid;


@Controller
public class RentalSpaceContractCotroller {

	@Autowired
	private RentalSpaceContractService rentalSpaContrac;

	@GetMapping("/createrentalSpaContracs")
	public String createRentalSpaContrac(Model model) {
		model.addAttribute("RentalSpa", new RentalSpaceContract ());
		model.addAttribute("apartments", rentalSpaContrac.findalApa());
		model.addAttribute("employees", rentalSpaContrac.findalEmploy());
		return "/RentalSpaceContract/AddRentalSpaceContract";
	}
	
	@PostMapping("/saverentalSpaContracs")
	public String saveRentalSpaContrac(Model model,@Valid @ModelAttribute("RentalSpa") RentalSpaceContract rentalSpaCon, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("apartments", rentalSpaContrac.findalApa());
			model.addAttribute("employees", rentalSpaContrac.findalEmploy());
			return "/RentalSpaceContract/AddRentalSpaceContract";
		}
		rentalSpaContrac.saveRentalSpaceContractDao(rentalSpaCon);
		return "redirect:/showrentalSpaContracs";
	}
	
	@GetMapping("/showrentalSpaContracs")
	public String showListRentalSpaCon(Model model, @RequestParam(name = "page", defaultValue = "1") int page) {
		int pageSize = 6;
		PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
		Page<RentalSpaceContract> allRentalSpaceContract = rentalSpaContrac.allRentalSpaceContract(pageRequest);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", allRentalSpaceContract.getTotalPages());
		model.addAttribute("listRentalSpa", allRentalSpaceContract.getContent());
		return "/RentalSpaceContract/listRentalSpaContrac";
	}
	

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
		return "/RentalSpaceContract/updateRenSpaCon";
	}
	@PostMapping("/saveupdaterenspacon")
	public String saveupdateRenSpaCon(@ModelAttribute("idrenspacon") RentalSpaceContract renspa) {
		rentalSpaContrac.updateRenSpaCon(renspa);
		return "redirect:/showrentalSpaContracs";
	}
	
	@GetMapping("/searchrentalspacon")
	public String searchRentalSpaceContract(Model model, @RequestParam(name = "searchKeyword", defaultValue = "") String search, @RequestParam(name = "page", defaultValue = "1") int page) {
		int pageSize = 6;
		PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
		Page<RentalSpaceContract> allRentalSpaceContract = rentalSpaContrac.seachRentalSpaceContract(pageRequest, search);
		model.addAttribute("currentPage", page);
		int totalPages ;
		if(allRentalSpaceContract.getTotalPages() < 1) {
			totalPages = 1 ;
		}else {
			totalPages = allRentalSpaceContract.getTotalPages();
		}
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("searchKeyword", search);
		model.addAttribute("listRentalSpa", allRentalSpaceContract.getContent());
		return "/RentalSpaceContract/listRentalSpaContrac";
	}
}
