package com.fa.BlueHouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fa.BlueHouse.services.EmployeeService;

@Controller
@RequestMapping(path = "/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService eService;

	@GetMapping("/list")
	public String showAll(Model model) {
		model.addAttribute("listEmp", eService.allEmployee());
		return "Employee/list";
	}

//	@GetMapping("search")
//	public String searchApartment(@RequestParam(name = "searchKeyword", defaultValue = "") String keyword, Model model,
//			@RequestParam(name = "page", defaultValue = "1") int page) {
//		int pageSize = 6;
//		PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
//		Page<Apartment> allApartments = eService.findApartmentsByKeyword(pageRequest, keyword);
//		model.addAttribute("currentPage", page);
//		int totalPages ;
//		if(allApartments.getTotalPages() < 1) {
//			totalPages = 1 ;
//		}else {
//			totalPages = allApartments.getTotalPages();
//		}
//		model.addAttribute("totalPages", totalPages);
//		model.addAttribute("searchKeyword", keyword);
//		model.addAttribute("listApartment", allApartments.getContent());
//		return "Apartment/list";
//
//	}

}
