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

import com.fa.BlueHouse.authen.model.Account;
import com.fa.BlueHouse.entities.Employee;
import com.fa.BlueHouse.entities.Resident;
import com.fa.BlueHouse.services.AccountService;
import com.fa.BlueHouse.services.EmployeeService;
import com.fa.BlueHouse.services.ResidentService;

@Controller
@RequestMapping(path = "/account")
public class AccountController {

	@Autowired
	private AccountService aService;
	
	@Autowired
	private EmployeeService eService;
	
	@Autowired
	private ResidentService rService;

	@GetMapping({ "/", "/list" })
	public String showAll(@RequestParam(name = "page", defaultValue = "1") int page, Model model) {

		int pageSize = 6;
		PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
		Page<Account> listAccount = aService.allAccount(pageRequest);

		int totalPages;
		if (listAccount.getTotalPages() < 1) {
			totalPages = 1;
		} else {
			totalPages = listAccount.getTotalPages();
		}

		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("listPaggin", listAccount.getContent());
		return "Account/list";
	}

	@GetMapping("/search")
	public String searchAll(@RequestParam(name = "searchKeyword", defaultValue = "") String keyword,
			@RequestParam(name = "page", defaultValue = "1") int page, Model model) {
		int pageSize = 6;
		PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
		Page<Account> listAccount = aService.findByKeyword(pageRequest, keyword);

		int totalPages;
		if (listAccount.getTotalPages() < 1) {
			totalPages = 1;
		} else {
			totalPages = listAccount.getTotalPages();
		}

		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("searchKeyword", keyword);
		model.addAttribute("listPaggin", listAccount.getContent());

		return "Account/list";
	}

	@GetMapping("/delete")
	public String deleteAcc(@RequestParam(name = "userName") String userName) {
		aService.deleteByUserName(userName);
		return "redirect:/account/list";
	}

	@GetMapping("/add")
	public String addAcc(Model model) {

		model.addAttribute("listEmp", aService.getEmpNotInAccount());
		model.addAttribute("listReci", aService.getReciNotInAccount());
		model.addAttribute("account", new Account());
		model.addAttribute("resident", new Resident());
		model.addAttribute("employee", new Employee());
		return "Account/addEdit";
	}

	@PostMapping("/save")
	public String saveAcc(@ModelAttribute("account") Account account, @ModelAttribute("employee") Employee emp,
			@ModelAttribute("resident") Resident resi) {

		if (account.getRole() == 1 || account.getRole() == 3) {
			for (Resident e : aService.getReciNotInAccount()) {
				if (e.getIdResident().equals(resi.getIdResident())) {
					resi = e;
					emp = null;
					break;
				}
			}
		} else {
			for (Employee e : aService.getEmpNotInAccount()) {
				if (e.getEmployeeID().equals(emp.getEmployeeID())) {
					emp = e;
					resi = null;
					break;
				}
			}
		}

		account.setEmployee(emp);
		account.setResident(resi);

		aService.saveAccount(account);
		return "redirect:/account/list";
	}

	@GetMapping("/edit")
	public String editEmp(Model model, @RequestParam(name = "userName") String userName) {
		Account acc = aService.findByUserName(userName);

		model.addAttribute("account", acc);
		model.addAttribute("resident", acc.getResident());
		model.addAttribute("employee", acc.getEmployee());

		return "Account/update";
	}

	@PostMapping("/update")
	public String updateEmp(@ModelAttribute("account") Account account, @ModelAttribute("employee") Employee emp,
			@ModelAttribute("resident") Resident resi) {
		
		if (emp.getEmployeeID() != null) {
			account.setEmployee(eService.findById(emp.getEmployeeID()));
			account.setResident(null);
		}else {
			account.setEmployee(null);
			account.setResident(rService.findById(resi.getIdResident()));
		}
		
		aService.saveAccount(account);
		return "redirect:/account/list";
	}

}
