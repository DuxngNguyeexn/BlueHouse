package com.fa.BlueHouse.controller;

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
import com.fa.BlueHouse.entities.RegisterForResidence;
import com.fa.BlueHouse.services.RegisterForResidenceServices;

import jakarta.validation.Valid;

@Controller
@RequestMapping(path = "registerForResidence")
public class RegisterForResidenceController {

	@Autowired
	private RegisterForResidenceServices residenceServices;
	
	@GetMapping({"/", "/list"})
	public String showRegisterForResidences(Model model, @RequestParam(name = "page", defaultValue = "1") int page) {
		
		int pageSize = 6;
		PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
		Page<RegisterForResidence> listRegisterForResidence = residenceServices.allRegisterForResidence(pageRequest);
		
		int totalPages;
		if (listRegisterForResidence.getTotalPages() < 1) {
			totalPages = 1;
		} else {
			totalPages = listRegisterForResidence.getTotalPages();
		}
		
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("listRegisterForResi", listRegisterForResidence.getContent());
		return "/RegisterForResidence/listRegisterForResidence";
	}
	
	@GetMapping("/search")
	public String searchRegisterForResidence(Model model, @RequestParam(name = "searchKeyword", defaultValue = "") String search, @RequestParam(name = "page", defaultValue = "1") int page) {
		int pageSize = 6;
		PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
		Page<RegisterForResidence> allRegisterForResidence = residenceServices.seachRegisterForResidence(pageRequest, search);
		
		int totalPages;
		if(allRegisterForResidence.getTotalPages() < 1) {
			totalPages = 1;
		}else {
			totalPages = allRegisterForResidence.getTotalPages();
		}
		
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("searchKeyword", search);
		model.addAttribute("listRegisterForResiPA", allRegisterForResidence.getContent());
		
		if (search.equalsIgnoreCase("")) {
			model.addAttribute("listRegisterForResi", residenceServices.findaRegiResi());
		} else {
			model.addAttribute("listRegisterForResi", residenceServices.findByKeyword(search));
		}
		
		return "/RegisterForResidence/listRegisterForResidence";
	}
	
	@GetMapping("/add")
	public String addRegiForResi(Model model) {
		model.addAttribute("registesresi", new RegisterForResidence());
		model.addAttribute("listapa", residenceServices.findaApa());
		model.addAttribute("listresi", residenceServices.findaResident());
		return "/RegisterForResidence/createRegisterForResidence";
	}
	
	@PostMapping("/save")
	public String saveRegiForResi(Model model,@Valid @ModelAttribute("registesresi") RegisterForResidence registerForResidence, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("listapa", residenceServices.findaApa());
			model.addAttribute("listresi", residenceServices.findaResident());
			return "/RegisterForResidence/createRegisterForResidence";
		}
		
		residenceServices.saveRegisterForResidence(registerForResidence);
		return "redirect:/registerForResidence/list";
	} 
	
	@GetMapping("/delete")
	public String deleteRegiForResi(@RequestParam("idregiresi") String id) {
		residenceServices.deleteRegisterResi(id);
		return "redirect:/registerForResidence/list";
	}

	@GetMapping("/edit")
	public String editRegiForResi(Model model, @RequestParam("idregiresi") String id) {
		model.addAttribute("listapa", residenceServices.findaApa());
		model.addAttribute("listresi", residenceServices.findaResident());
		model.addAttribute("registesresi", residenceServices.findaById(id));
		return "/RegisterForResidence/createRegisterForResidence";
	}
	
	@PostMapping("/update")
	public String updateRegiForResi(@ModelAttribute("registesresi") RegisterForResidence registerForResidence) {
		residenceServices.updateRegisterResi(registerForResidence);
		return "redirect:/registerForResidence/list";
	}
	
}
