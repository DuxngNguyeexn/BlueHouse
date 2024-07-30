package com.fa.BlueHouse.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/Assets")
public class AssetController {
	@GetMapping("")
	public List<String> showAllAsset(){
		return List.of("table","chair");
	}
}
