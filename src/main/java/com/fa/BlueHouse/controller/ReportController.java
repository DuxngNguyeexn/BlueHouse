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
import com.fa.BlueHouse.entities.form.Report;
import com.fa.BlueHouse.services.ReportService;
import com.fa.BlueHouse.services.ResidentService;

@Controller
@RequestMapping(path = "/Form/Report/")
public class ReportController {
	@Autowired
	ReportService reportService;
	@Autowired
	ResidentService residentService;
	@GetMapping("list")
	public String showAll(@RequestParam(name = "page", defaultValue = "1") int page, Model model) {
		int pageSize = 6;
		PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
		Page<Report> listAll = reportService.showAll(pageRequest);
		model.addAttribute("currentPage", page);
		int totalPages ;
		if(listAll.getTotalPages() < 1) {
			totalPages = 1 ;
		}else {
			totalPages = listAll.getTotalPages();
		}
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("listAll", listAll.getContent());
		return "Form/Report/list";
	}
	@GetMapping("showAdd")
	public String showAdd(Model model) {
		Resident resident = residentService.findById("R001");
		Report form = new Report();	
		form.setResident(resident);
		model.addAttribute("form", form);
		return "Form/Report/add";
	}
	
	@PostMapping("add")
	public String save(
			@ModelAttribute(name = "form") Report form,
			BindingResult bindingResult) {
		form.setIdForm(reportService.generateNewId());
		form.setStatus("Send");
		form.setDateSent(new Date());
		reportService.save(form);
		return "redirect:list";
		
	}
}
