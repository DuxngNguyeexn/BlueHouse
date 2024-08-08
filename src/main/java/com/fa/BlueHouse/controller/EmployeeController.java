package com.fa.BlueHouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fa.BlueHouse.entities.Employee;
import com.fa.BlueHouse.services.EmployeeService;

@Controller
@RequestMapping(path = "/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService eService;

	@GetMapping({ "/", "/list" })
	public String showAll(@RequestParam(name = "page", defaultValue = "1") int page, Model model) {

		int pageSize = 6;
		PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
		Page<Employee> listEmployee = eService.allEmployee(pageRequest);

		int totalPages;
		if (listEmployee.getTotalPages() < 1) {
			totalPages = 1;
		} else {
			totalPages = listEmployee.getTotalPages();
		}

		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("listEmpPaggin", listEmployee.getContent());
		model.addAttribute("listEmp", eService.allEmployee());
		return "Employee/list";
	}

	@GetMapping("/search")
	public String searchAll(@RequestParam(name = "searchKeyword", defaultValue = "") String keyword,
			@RequestParam(name = "page", defaultValue = "1") int page, Model model) {
		int pageSize = 6;
		PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
		Page<Employee> listEmployee = eService.findByKeyword(pageRequest, keyword);

		int totalPages;
		if (listEmployee.getTotalPages() < 1) {
			totalPages = 1;
		} else {
			totalPages = listEmployee.getTotalPages();
		}

		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("searchKeyword", keyword);
		model.addAttribute("listEmpPaggin", listEmployee.getContent());

		if (keyword.equalsIgnoreCase("")) {
			model.addAttribute("listEmp", eService.allEmployee());
		} else {
			model.addAttribute("listEmp", eService.findByKeyword(keyword));
		}

		return "Employee/list";

	}

	@GetMapping("/add")
	public String addEmp(Model model) {
		model.addAttribute("employee", new Employee());
		return "Employee/addEditEmployee";
	}

	@PostMapping("/save")
	public String saveEmp(@ModelAttribute("employee") Employee employee, Model model) {
		eService.saveEmployee(employee);
		return "redirect:/employee/list";
	}

	@GetMapping("/delete")
	public String deleteEmp(@RequestParam("employeeID") String id) {
		eService.deleteByID(id);
		return "redirect:/employee/list";
	}

	@GetMapping("/edit")
	public String editEmp(Model model, @RequestParam("employeeID") String id) {
		model.addAttribute("employee", eService.findById(id));
		return "Employee/addEditEmployee";
	}

	@PostMapping("/update")
	public String updateEmp(@ModelAttribute("employee") Employee employee) {
		eService.saveEmployee(employee);
		return "redirect:/employee/list";
	}

}
