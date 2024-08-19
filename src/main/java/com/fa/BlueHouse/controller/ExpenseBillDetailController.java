package com.fa.BlueHouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fa.BlueHouse.services.ExpenseBillDetailService;

@Controller
@RequestMapping("ExpenseBillDetail")
public class ExpenseBillDetailController {

	@Autowired
	private ExpenseBillDetailService expendetail;
}
