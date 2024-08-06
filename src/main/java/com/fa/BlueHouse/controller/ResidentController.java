package com.fa.BlueHouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fa.BlueHouse.entities.Apartment;
import com.fa.BlueHouse.entities.Resident;
import com.fa.BlueHouse.services.ResidentService;

@Controller
public class ResidentController {
	@Autowired
	private ResidentService resident;

	@GetMapping("/createresident")
	public String createResident(Model model) {
		model.addAttribute("listapartment", resident.findallapart());
		return "/Resident/createResident";
	}

	@PostMapping("/saveresident")
	public String saveResident(Model model, @ModelAttribute Resident resi) {
		System.out.println(resi.toString());
		resident.saveResident(resi);
		return "redirect:/showlistresident";
	}

	@GetMapping("/showlistresident")
	public String showlistResident(Model model) {
		List<Resident> listresi = resident.findallResident();
		model.addAttribute("listResident", listresi);
		return "/Resident/listResident";
	}

	@GetMapping("/searchrisedent")
	public String searchResident(Model model, @RequestParam("search") String search) {
		model.addAttribute("listResident", resident.searchResident(search));
		return "/Resident/listResident";
	}

	@GetMapping("/deleterisedent")
	public String deleteResident(@RequestParam("idresident") String id) {
		resident.deleteResident(id);
		return "redirect:/showlistresident";
	}

	@GetMapping("/editresident")
	public String editResident(Model model, @RequestParam("idresident") String id) {
		List<Apartment> listresi = resident.findallapart();
		model.addAttribute("listapartment", listresi);
		model.addAttribute("resident", resident.findById(id));
		return "/Resident/updateResident";
	}
	@PostMapping("/saveupdateresident")
	public String saveupdateresident(@ModelAttribute("resident") Resident resi) {
		resident.updateResident(resi);
		return "redirect:/showlistresident";
	}

}
