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
import com.fa.BlueHouse.entities.RegisterForResidence;
import com.fa.BlueHouse.services.RegisterForResidenceServices;

import jakarta.validation.Valid;

@Controller
public class RegisterForResidenceController {

	@Autowired
	private RegisterForResidenceServices residenceServices;
	
	@GetMapping("/createRegisterForResidence")
	public String createRegisterForResidences(Model model) {
		model.addAttribute("registesresi", new RegisterForResidence());
		model.addAttribute("listapa", residenceServices.findaApa());
		model.addAttribute("listresi", residenceServices.findaResident());
		return "/RegisterForResidence/createRegisterForResidence";
	}
	
	@PostMapping("/saveRegisterForResidence")
	public String saveRegisterForResidences(Model model,@Valid @ModelAttribute("registesresi") RegisterForResidence registerForResidence, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("listapa", residenceServices.findaApa());
			model.addAttribute("listresi", residenceServices.findaResident());
			return "/RegisterForResidence/createRegisterForResidence";
		}
		residenceServices.saveRegisterForResidence(registerForResidence);
		return "redirect:/showRegisterForResidence";
	}
	
	@GetMapping("/showRegisterForResidence")
	public String showRegisterForResidences(Model model, @RequestParam(name = "page", defaultValue = "1") int page) {
		int pageSize = 6;
		PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
		Page<RegisterForResidence> allRegisterForResidence = residenceServices.allRegisterForResidence(pageRequest);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", allRegisterForResidence.getTotalPages());
		model.addAttribute("listRegisterForResi", allRegisterForResidence.getContent());
		return "/RegisterForResidence/listRegisterForResidence";
	}
	
	@GetMapping("/deleteRegisterForResidence")
	public String deleteRegisterForResidence(@RequestParam("idregiresi") String id) {
		residenceServices.deleteRegisterResi(id);
		return "redirect:/showRegisterForResidence";
	}

	@GetMapping("/editRegisterForResidence")
	public String editRegisterForResidence(Model model, @RequestParam("idregiresi") String id) {
		List<RegisterForResidence> listregiresi = residenceServices.findaRegiResi();
		model.addAttribute("listregiresi", listregiresi);
		model.addAttribute("listapa", residenceServices.findaApa());
		model.addAttribute("listresi", residenceServices.findaResident());
		model.addAttribute("regiresi", residenceServices.findaById(id));
		return "/RegisterForResidence/updateRegisterForResidence";
	}
	
	@PostMapping("/updateRegisterForResidence")
	public String updateRegisterForResidence(@ModelAttribute("idregiresi") RegisterForResidence registerForResidence) {
		residenceServices.updateRegisterResi(registerForResidence);
		return "redirect:/showRegisterForResidence";
	}
	
	@GetMapping("/searchRegisterForResidence")
	public String searchRegisterForResidence(Model model, @RequestParam(name = "searchKeyword", defaultValue = "") String search, @RequestParam(name = "page", defaultValue = "1") int page) {
		int pageSize = 6;
		PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
		Page<RegisterForResidence> allRegisterForResidence = residenceServices.seachRegisterForResidence(pageRequest, search);
		model.addAttribute("currentPage", page);
		int totalPages;
		if(allRegisterForResidence.getTotalPages() < 1) {
			totalPages = 1;
		}else {
			totalPages = allRegisterForResidence.getTotalPages();
		}
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("searchKeyword", search);
		model.addAttribute("listRegisterForResi", allRegisterForResidence.getContent());
		return "/RegisterForResidence/listRegisterForResidence";
	}
	
}
