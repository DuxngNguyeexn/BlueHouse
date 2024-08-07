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
import org.springframework.web.bind.annotation.RequestParam;

import com.fa.BlueHouse.entities.Administrators;
import com.fa.BlueHouse.services.AdministratorsService;
import com.fa.BlueHouse.services.PositionService;
import com.fa.BlueHouse.services.ResidentService;

import jakarta.validation.Valid;

@Controller
public class AdministratorsController {

	@Autowired
	private AdministratorsService adminis;
	@Autowired
	private ResidentService resident;
	@Autowired
	private PositionService posi;
	
	@GetMapping("/createadminis")
	public String createAdministrators(Model model) {
	    model.addAttribute("Adminis", new Administrators());
		model.addAttribute("resident", resident.findallResident());
		model.addAttribute("position", posi.findall());
		return "/Administrators/createAdminis";
	}
	
	@PostMapping("/saveadminis")
	public String saveAdminis(Model model,@Valid @ModelAttribute("Adminis") Administrators admin, BindingResult result) {
		if(result.hasErrors()) {
			model.addAttribute("resident", resident.findallResident());
			model.addAttribute("position", posi.findall());
			return "/Administrators/createAdminis";
		}else {
			adminis.saveAdminis(admin);
			return "redirect:/showlistadminis";
		}
		
	}
	
	@GetMapping("/showlistadminis")
	public String showlistAdminis(Model model, @RequestParam(name = "page", defaultValue = "1") int page) {
		int pageSize = 6;
		PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
		Page<Administrators> listadmin = adminis.findpageAdmin(pageRequest);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", listadmin.getTotalPages());
		model.addAttribute("listAdminis", listadmin.getContent());
		return "/Administrators/listAdminis";
	}
	@GetMapping("/searchadminis")
	public String searchResident(@RequestParam(name = "searchKeyword", defaultValue = "") String keyword, Model model,
			@RequestParam(name = "page", defaultValue = "1") int page) {
		int pageSize = 6;
		PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
		Page<Administrators> listadmin = adminis.findsearchAdmin(keyword, pageRequest);
		model.addAttribute("currentPage", page);
		int totalPages ;
		if(listadmin.getTotalPages() < 1) {
			totalPages = 1 ;
		}else {
			totalPages = listadmin.getTotalPages();
		}
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("searchKeyword", keyword);
		model.addAttribute("listAdminis", listadmin.getContent());
		return "/Administrators/listAdminis";
		}
	@GetMapping("/editAdminis")
	public String editAdminis(Model model, @RequestParam("idBQT") String id) {
		model.addAttribute("resident", resident.findallResident());
		model.addAttribute("position", posi.findall());
		model.addAttribute("Adminis", adminis.findById(id));
		return "/AdminisTrators/updateAdminis";
	}
	@GetMapping("/deleteAdminis")
	public String deleteAdminis(@RequestParam("idBQT") String id) {
		adminis.deleteAdminis(id);
		return "redirect:/showlistadminis";
	}
}
