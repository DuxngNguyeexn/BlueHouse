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
import com.fa.BlueHouse.entities.VehicleRegistration;
import com.fa.BlueHouse.services.VehicleRegistrationService;

import jakarta.validation.Valid;

@Controller
public class VehicleRegistrationController {

	@Autowired
	private VehicleRegistrationService vehicleRegistrationService;
	
	@GetMapping("/createVehicleRegistration")
	public String createVehicleRegistration(Model model) {
		model.addAttribute("vehicleregi", new VehicleRegistration());
		model.addAttribute("listapa", vehicleRegistrationService.findaApartment());
		model.addAttribute("listfee", vehicleRegistrationService.findaFeeType());
		return "/VehicleRegistration/CreateVehicleRegistration";
	}
	
	@PostMapping("/saveVehicleRegistration")
	public String saveVehicleRegistration(Model model,@Valid @ModelAttribute("vehicleregi") VehicleRegistration vehicleRegistration, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("listapa", vehicleRegistrationService.findaApartment());
			model.addAttribute("listfee", vehicleRegistrationService.findaFeeType());
			return "/VehicleRegistration/CreateVehicleRegistration";
		}
		vehicleRegistrationService.saveVehicleRegistration(vehicleRegistration);
		return "redirect:/showVehicleRegistration";
	}
	
	@GetMapping("/showVehicleRegistration")
	public String showVehicleRegistration(Model model, @RequestParam(name = "page", defaultValue = "1") int page) {
		int pageSize = 6;
		PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
		Page<VehicleRegistration> allVehicleRegistration = vehicleRegistrationService.allVehicleRegistration(pageRequest);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", allVehicleRegistration.getTotalPages());
		model.addAttribute("listVehicleRegistration", allVehicleRegistration.getContent());
		return "/VehicleRegistration/listVehicleRegistration";
	}
	
	@GetMapping("/deleteVehicleRegistration")
	public String deleteVehicleRegistration(@RequestParam("idvehicle") String id) {
		vehicleRegistrationService.deleteVehicleRegistration(id);
		return "redirect:/showVehicleRegistration";
	}

	@GetMapping("/editVehicleRegistration")
	public String editVehicleRegistration(Model model, @RequestParam("idvehicle") String id) {
		List<VehicleRegistration> listvehicle = vehicleRegistrationService.findaVehicleRegi();
		model.addAttribute("listvehicle", listvehicle);
		model.addAttribute("listapa", vehicleRegistrationService.findaApartment());
		model.addAttribute("listfee", vehicleRegistrationService.findaFeeType());
		model.addAttribute("vehicleregi", vehicleRegistrationService.findaById(id));
		return "/VehicleRegistration/updateVehicleRegistration";
	}
	
	@PostMapping("/updateVehicleRegistration")
	public String updateVehicleRegistration(@ModelAttribute("idregiresi") VehicleRegistration vehicleRegistration) {
		vehicleRegistrationService.updateVehicleRegistration(vehicleRegistration);
		return "redirect:/showVehicleRegistration";
	}
	
	@GetMapping("/searchVehicleRegistration")
	public String searchVehicleRegistration(Model model, @RequestParam(name = "searchKeyword", defaultValue = "") String search, @RequestParam(name = "page", defaultValue = "1") int page) {
		int pageSize = 6;
		PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
		Page<VehicleRegistration> allVehicleRegistration = vehicleRegistrationService.seachVehicleRegistration(pageRequest, search);
		model.addAttribute("currentPage", page);
		int totalPages;
		if(allVehicleRegistration.getTotalPages() < 1) {
			totalPages = 1;
		}else {
			totalPages = allVehicleRegistration.getTotalPages();
		}
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("searchKeyword", search);
		model.addAttribute("listVehicleRegistration", allVehicleRegistration.getContent());
		return "/VehicleRegistration/listVehicleRegistration";
	}
}
