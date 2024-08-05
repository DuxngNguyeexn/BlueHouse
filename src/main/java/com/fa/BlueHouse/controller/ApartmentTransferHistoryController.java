package com.fa.BlueHouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fa.BlueHouse.entities.ApartmentTransferHistory;
import com.fa.BlueHouse.services.ApartmentTransferHistoryService;

@Controller
@RequestMapping(path = "/ApartmentTransferHistory/")
public class ApartmentTransferHistoryController {
	@Autowired
	ApartmentTransferHistoryService apartmentTransferHistoryService;

	@GetMapping("list")
	public String showAll(@RequestParam(name = "page", defaultValue = "1") int page, Model model) {
		int pageSize = 6;
		PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
		Page<ApartmentTransferHistory> allApartmentTransferHistory = apartmentTransferHistoryService.showAll(pageRequest);
		model.addAttribute("currentPage", page);
		int totalPages ;
		if(allApartmentTransferHistory.getTotalPages() < 1) {
			totalPages = 1 ;
		}else {
			totalPages = allApartmentTransferHistory.getTotalPages();
		}
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("listAll", allApartmentTransferHistory.getContent());
		return "ApartmentTransferHistory/list";
	}
}
