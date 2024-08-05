package com.fa.BlueHouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
	@GetMapping("/")
	public String testHome() {
		return "HomePage";
	}

}
