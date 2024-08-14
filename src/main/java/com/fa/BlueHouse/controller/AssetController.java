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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fa.BlueHouse.entities.Assets;
import com.fa.BlueHouse.entities.Employee;
import com.fa.BlueHouse.entities.IdAssets;
import com.fa.BlueHouse.services.AssetService;
import com.fa.BlueHouse.services.EmployeeService;

import jakarta.validation.Valid;

@Controller
@RequestMapping(path = "Asset")
public class AssetController {
	@Autowired
	AssetService assetService;
	@Autowired
	EmployeeService employeeService;

	@GetMapping("list")
	public String showAll(@RequestParam(name = "page", defaultValue = "1") int page, Model model) {
		int pageSize = 6;
		PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
		Page<Assets> allList = assetService.showAll(pageRequest);
		model.addAttribute("currentPage", page);
		int totalPages;
		if (allList.getTotalPages() < 1) {
			totalPages = 1;
		} else {
			totalPages = allList.getTotalPages();
		}
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("listAll", allList.getContent());
		return "Asset/list";
	}


	@GetMapping("showAdd")
	public String showAdd(Model model) {
		Employee employee = employeeService.findById("E001");
		IdAssets idAsset = new IdAssets();
		String id = assetService.generateNewId();
		idAsset.setIdAsset(id);
		Assets asset = new Assets();
		asset.setEmploy(employee);
		asset.setId(idAsset);
		model.addAttribute("form", asset);
		return "Asset/add";
	}

	@PostMapping("add")
	public String save(@Valid @ModelAttribute(name = "form") Assets form, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "Asset/add";
		}
		assetService.save(form);
		return "redirect:list";

	}

	@GetMapping("showUpdate")
	public String showUpdate(Model model, @RequestParam(name = "id") String id,
			@RequestParam(name = "location") String location) {
		IdAssets idAs = new IdAssets(id, location);
		Assets asset = assetService.findById(idAs);
		model.addAttribute("form", asset);
		return "Asset/update";
	}

	@GetMapping("search")
	public String search(@RequestParam(name = "searchKeyword", defaultValue = "") String keyword, Model model,
			@RequestParam(name = "page", defaultValue = "1") int page) {
		int pageSize = 6;
		PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
		Page<Assets> all = assetService.findByKeyword(pageRequest, keyword);
		model.addAttribute("currentPage", page);
		int totalPages;
		if (all.getTotalPages() < 1) {
			totalPages = 1;
		} else {
			totalPages = all.getTotalPages();
		}
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("searchKeyword", keyword);
		model.addAttribute("listAll", all.getContent());
		return "Asset/list";

	}

	@GetMapping("delete")
	public String delete(Model model, @RequestParam(name = "id") String id,
			@RequestParam(name = "location", defaultValue = "") String location, @RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "searchKeyword", defaultValue = "") String keyword) {
		IdAssets idAs = new IdAssets(id, location);
		assetService.delete(assetService.findById(idAs));
		int pageSize = 6;
		PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
		Page<Assets> all = assetService.findByKeyword(pageRequest, keyword);
		model.addAttribute("currentPage", page);
		int totalPages;
		if (all.getTotalPages() < 1) {
			totalPages = 1;
		} else {
			totalPages = all.getTotalPages();
		}
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("searchKeyword", keyword);
		model.addAttribute("listAll", all.getContent());
		return "redirect:list?page=" + page;
	}
}
