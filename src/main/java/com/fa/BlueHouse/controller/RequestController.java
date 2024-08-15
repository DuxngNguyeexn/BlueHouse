package com.fa.BlueHouse.controller;

import java.util.Date;

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

import com.fa.BlueHouse.entities.Resident;
import com.fa.BlueHouse.entities.form.Request;
import com.fa.BlueHouse.services.RequestService;
import com.fa.BlueHouse.services.ResidentService;

@Controller
@RequestMapping(path = "/Form/Request/")
public class RequestController {
	@Autowired
	RequestService requestService;
	@Autowired
	ResidentService residentService;
	@GetMapping("list")
	public String showAll(@RequestParam(name = "page", defaultValue = "1") int page, Model model) {
		int pageSize = 6;
		PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
		Page<Request> listAll = requestService.showAll(pageRequest);
		model.addAttribute("currentPage", page);
		int totalPages ;
		if(listAll.getTotalPages() < 1) {
			totalPages = 1 ;
		}else {
			totalPages = listAll.getTotalPages();
		}
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("listAll", listAll.getContent());
		return "Form/Request/list";
	}
	@GetMapping("showAdd")
	public String showAdd(Model model) {
		Resident resident = residentService.findById("R001");
		Request form = new Request();	
		form.setResident(resident);
		model.addAttribute("form", form);
		return "Form/Request/add";
	}
	
	@PostMapping("add")
	public String save(
			@ModelAttribute(name = "form") Request form,
			BindingResult bindingResult) {
		form.setIdForm(requestService.generateNewId());
		form.setStatus("Send");
		form.setDateSent(new Date());
		requestService.save(form);
		return "redirect:list";
		
	}
	@GetMapping("showDetail")
	public String showDetail(@RequestParam(name = "id")String id,Model model) {
		Request form = requestService.findById(id);
		model.addAttribute("form", form);
		return "Form/detail";
	}
}
