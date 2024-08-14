package com.fa.BlueHouse.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fa.BlueHouse.entities.HistoryCustomerVehicle;
import com.fa.BlueHouse.entities.HistoryCustomerVehicleID;
import com.fa.BlueHouse.services.HistoryCustomerVehicleServices;

import jakarta.validation.Valid;

@Controller
public class HistoryCustomerVehicleController {

	@Autowired
	private HistoryCustomerVehicleServices hisCusVehiServices;
	
	@GetMapping("/createhiscusvehi")
	public String createHisCusVehi(Model model) {
		model.addAttribute("hiscusvehi", new HistoryCustomerVehicle ());
		model.addAttribute("apartments", hisCusVehiServices.findaApa());
		return "/HistoryCustomerVehicle/createHistoryCustomerVehicle";
	}
	
	@PostMapping("/saverhiscusvehi")
	public String saveHisCusVehi(Model model,@Valid @ModelAttribute("hiscusvehi") HistoryCustomerVehicle hitoryscusvehi, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("apartments", hisCusVehiServices.findaApa());
			return "/HistoryCustomerVehicle/createHistoryCustomerVehicle";
		}
		hisCusVehiServices.saveHistoryCustomerVehicle(hitoryscusvehi);
		return "redirect:/showhiscusvehi";
	}
	
	@GetMapping("/showhiscusvehi")
	public String showListHisCusVehi(Model model, @RequestParam(name = "page", defaultValue = "1") int page) {
		int pageSize = 6;
		PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
		Page<HistoryCustomerVehicle> allhiscusvehi = hisCusVehiServices.allHistoryCustomerVehicle(pageRequest);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", allhiscusvehi.getTotalPages());
		model.addAttribute("listhiscusvehi", allhiscusvehi.getContent());
		return "/HistoryCustomerVehicle/listHistoryCustomerVehicle";
	}
	

	@GetMapping("/deletehiscusvehi")
	public String deleteHisCusVehi(@RequestParam("idhiscusvehi") HistoryCustomerVehicleID id) {
		hisCusVehiServices.deleteHistoryCustomerVehicle(id);
		return "redirect:/showhiscusvehi";
	}

	@GetMapping("/xera")
	public String xeRa(@RequestParam("idhiscusvehi") String vehicleNumber, @RequestParam("idmoveInDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime moveInDate) {
		HistoryCustomerVehicleID id = new HistoryCustomerVehicleID(vehicleNumber, moveInDate);
        hisCusVehiServices.updateMoveOutDate(id);
        return "redirect:/showhiscusvehi";
    }
	
//	@GetMapping("/xevao")
//    public String xeVao(@RequestParam("idhiscusvehi") String vehicleNumber) {
//        hisCusVehiServices.updateMoveInDate(vehicleNumber, LocalDate.now());
//        return "redirect:/showhiscusvehi";
//    }
	
	@GetMapping("/searchhiscusvehi")
	public String searchHisCusVehi(Model model, @RequestParam(name = "searchKeyword", defaultValue = "") String search, @RequestParam(name = "page", defaultValue = "1") int page) {
		int pageSize = 6;
		PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
		Page<HistoryCustomerVehicle> allHisCusVehi = hisCusVehiServices.seachHistoryCustomerVehicle(pageRequest, search);
		model.addAttribute("currentPage", page);
		int totalPages ;
		if(allHisCusVehi.getTotalPages() < 1) {
			totalPages = 1 ;
		}else {
			totalPages = allHisCusVehi.getTotalPages();
		}
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("searchKeyword", search);
		model.addAttribute("listhiscusvehi", allHisCusVehi.getContent());
		return "/HistoryCustomerVehicle/listHistoryCustomerVehicle";
	}
}
