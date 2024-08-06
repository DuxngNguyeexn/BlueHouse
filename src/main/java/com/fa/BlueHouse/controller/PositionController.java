package com.fa.BlueHouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fa.BlueHouse.entities.Position;
import com.fa.BlueHouse.services.PositionService;

@Controller
public class PositionController {

	@Autowired
	private PositionService position;
	
	@RequestMapping("/createposition")
	public String createPosition() {
		return "Position/createPosition";
	}
	@PostMapping("/saveposition")
	public String savePosition(Model model, @ModelAttribute Position posi) {
		position.savePosition(posi);
		return "redirect:/showlistposition";
	}
	@GetMapping("/showlistposition")
	public String showlistPosition(Model model) {
		model.addAttribute("listPosition", position.findall());
		return "Position/listPosition";
	}
	@GetMapping("/editposition")
	public String editPosition(Model model, @RequestParam("idPosition") String id) {
	   model.addAttribute("position", position.findById(id));
	   return "Position/updatePosition";
	}
	
	@GetMapping("/deleteposition")
	public String deletePosition(Model model, @RequestParam("idPosition") String id) {
		position.deletePosition(id);
		return "redirect:/showlistposition";
	}
	
	@GetMapping("/searchposition")
	public String searchPosition(Model model, @RequestParam("search") String search) {
		model.addAttribute("listPosition", position.searchPosition(search));
		return "Position/listPosition";
	}
}
