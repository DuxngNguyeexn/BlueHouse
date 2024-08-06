package com.fa.BlueHouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
	@GetMapping("/")
	public String showLogin() {
		return "HomePage";
	}
	
	@GetMapping("/signUp")
	public String showSignUp() {
		return "SignUp";
	}
	public String testHome() {
		return "HomePage";
	}

}
