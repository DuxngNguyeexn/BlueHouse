package com.fa.BlueHouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fa.BlueHouse.authen.model.Account;
import com.fa.BlueHouse.entities.Employee;
import com.fa.BlueHouse.entities.Resident;
import com.fa.BlueHouse.services.AccountService;

@Controller
public class LoginController {

	@Autowired
	private AccountService aService;

	@GetMapping("login")
	public String login() {
		return "login";
	}

	@GetMapping("forgot")
	public String forgot() {
		return "ForgotPassWord";
	}

	@PostMapping("/forgot/disable")
	public String disable(@RequestParam(name = "userName") String userName,
			@RequestParam(name = "fullName") String fullName, @RequestParam(name = "phone") String phone,
			@RequestParam(name = "nationId") String nationId) {

		List<Account> listAcc = aService.allAccount();
		int check = 1;

		for (Account acc : listAcc) {

			Employee emp = acc.getEmployee();
			Resident resi = acc.getResident();

			if (!acc.getUsername().equals(userName)) {
				check = 0;
			} else if (emp != null && (!emp.getFullName().equals(fullName) || !emp.getPhoneNumber().equals(phone)
					|| !emp.getNationalID().equals(nationId))) {
				check = 0;
			} else if (resi != null && (!resi.getNameResident().equals(fullName) || !resi.getPhonenumber().equals(phone)
					|| !resi.getIdentificationCard().equals(nationId))) {
				check = 0;
			}

			if (check == 1) {
				acc.setActive(0);
				aService.saveAccount(acc);
				return "redirect:/forgot/success?status=1";
			}
		}

		return "redirect:/forgot/success?status=0";
	}
	
	@GetMapping("/forgot/success")
	public String pagesucces(@RequestParam(name = "status") String status, Model model) {
		
		model.addAttribute("status", status);
		
		return "SuccessForgot";
	}

}
