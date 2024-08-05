package com.fa.BlueHouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class test {
	@GetMapping("/")
	public String showLogin() {
		return "login";
	}
	
	@GetMapping("/signUp")
	public String showSignUp() {
		return "SignUp";
	}

}
