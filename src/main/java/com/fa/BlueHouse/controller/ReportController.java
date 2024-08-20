package com.fa.BlueHouse.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fa.BlueHouse.authen.model.AccountDTO;
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
	 private final String uploadDir = "E:\\TaiLieu\\Mock project\\img";
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
	public String showAdd(Principal principal, Model model) {
		AccountDTO userDetails = (AccountDTO) ((Authentication) principal).getPrincipal();
		String id = userDetails.getId();
		Resident resident = residentService.findById(id);
		Report form = new Report();	
		form.setResident(resident);
		model.addAttribute("form", form);
		return "Form/Report/add";
	}
	
	@PostMapping("add")
	public String save(
			@ModelAttribute(name = "form") Report form,
			BindingResult bindingResult,
			 @RequestParam("file") MultipartFile file,
			 RedirectAttributes redirectAttributes) {
		if(file != null) {
			try {
			 String fileName = file.getOriginalFilename();
	            Path path = Paths.get(uploadDir + File.separator + fileName);
	            Files.write(path, file.getBytes());
	            form.setImagePath(fileName);
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		form.setIdForm(reportService.generateNewId());
		form.setStatus("Send");
		form.setDateSent(new Date());
		reportService.save(form);
		return "redirect:list";
		
	}
}
