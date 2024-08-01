package com.fa.BlueHouse.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fa.BlueHouse.entities.Resident;

@Controller
public class BluehouseController {
	@GetMapping("/listresident")
	public String listResident(Model model) {
		List<Resident> resi = new ArrayList<Resident>();
		model.addAttribute("listresident", resi);
		return "/listResident";
	}
}
