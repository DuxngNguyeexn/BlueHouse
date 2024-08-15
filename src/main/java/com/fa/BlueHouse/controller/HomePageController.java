package com.fa.BlueHouse.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fa.BlueHouse.authen.model.AccountDTO;

@Controller
public class HomePageController {
	@GetMapping("/")
	public String showLogin(Principal principal, Model model) {

//		AccountDTO thongTin = (AccountDTO) ((Authentication) principal).getPrincipal();
		

		return "HomePage";
	}

}
