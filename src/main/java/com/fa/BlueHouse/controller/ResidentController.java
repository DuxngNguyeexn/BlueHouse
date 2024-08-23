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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fa.BlueHouse.authen.model.Account;
import com.fa.BlueHouse.entities.Apartment;
import com.fa.BlueHouse.entities.Resident;
import com.fa.BlueHouse.services.AccountService;
import com.fa.BlueHouse.services.ResidentService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/Resident")
public class ResidentController {
	@Autowired
	private ResidentService resident;

	@Autowired
	private AccountService accService;

	@GetMapping("/createresident")
	public String createResident(Model model) {
		model.addAttribute("resident", new Resident());
		model.addAttribute("listapartment", resident.findallapart());
		return "/Resident/createResident";
	}

	@PostMapping("/saveresident")
	public String saveResident(Model model, @Valid @ModelAttribute Resident resi, BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("listapartment", resident.findallapart());
			return "/Resident/createResident";
		}
		resident.saveResident(resi);
		return "redirect:/Resident/showlistresident";
	}

	@GetMapping("/showlistresident")
	public String showlistResident(Model model, @RequestParam(name = "page", defaultValue = "1") int page) {
		int pageSize = 6;
		PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
		Page<Resident> listresi = resident.findpageResident(pageRequest);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", listresi.getTotalPages());
		model.addAttribute("listResident", listresi.getContent());
		return "/Resident/listResident";
	}

	@GetMapping("/searchrisedent")
	public String searchResident(@RequestParam(name = "searchKeyword", defaultValue = "") String keyword, Model model,
			@RequestParam(name = "page", defaultValue = "1") int page) {
		int pageSize = 6;
		PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
		Page<Resident> listresi = resident.searchResident(keyword, pageRequest);
		model.addAttribute("currentPage", page);
		int totalPages;
		if (listresi.getTotalPages() < 1) {
			totalPages = 1;
		} else {
			totalPages = listresi.getTotalPages();
		}
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("searchKeyword", keyword);
		model.addAttribute("listResident", listresi.getContent());
		return "/Resident/listResident";
	}

	@GetMapping("/deleterisedent")
	public String deleteResident(@RequestParam("idresident") String id) {

		for (Account acc : accService.getAccByResi(id)) {
			accService.deleteByUserName(acc.getUsername());
		}

		resident.deleteResident(id);
		return "redirect:/Resident/showlistresident";
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
		return "redirect:/Resident/showlistresident";
	}

}
