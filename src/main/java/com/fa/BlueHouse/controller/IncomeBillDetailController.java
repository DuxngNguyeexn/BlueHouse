package com.fa.BlueHouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fa.BlueHouse.entities.FeeType;
import com.fa.BlueHouse.entities.IncomeBill;
import com.fa.BlueHouse.entities.IncomeBillDetail;
import com.fa.BlueHouse.services.ApartmentService;
import com.fa.BlueHouse.services.FeetypeService;
import com.fa.BlueHouse.services.IncomeBillDetailService;
import com.fa.BlueHouse.services.IncomeBillService;

@Controller
public class IncomeBillDetailController {

	@Autowired
	private IncomeBillDetailService indetail;
	@Autowired
	private IncomeBillService inbill;
	@Autowired
	private FeetypeService feetype;
	@Autowired
    private ApartmentService apart;
	
	@GetMapping("/showlishtdetail")
	public String findallDetail(Model model, @RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam("idbill") String idbill, @RequestParam("idapart") String idapart) {
		int pageSize = 6;
		PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
		IncomeBill bill = inbill.findById(idbill);
		Page<IncomeBillDetail> listdetail = indetail.findAllbill(idbill, pageRequest);
		model.addAttribute("IncomeBill", bill);
		model.addAttribute("currentPage", page);
		model.addAttribute("apartment", apart.findById(idapart));
		model.addAttribute("totalPages", listdetail.getTotalPages());
		model.addAttribute("listDetail", listdetail.getContent());
		return "/IncomeBillDetail/listInDetail";
	}
	@GetMapping("/createBillDetail")
	public String createBillDetail(Model model,@RequestParam(name = "idinbill", defaultValue = "#{null}" )String id ) {
		if(id != null) {
			model.addAttribute("billDetail", new IncomeBillDetail(inbill.findById(id)));
			model.addAttribute("listfee", feetype.findallFeetype());
			return "/IncomeBillDetail/createBillDetail";
		}else {
			model.addAttribute("billDetail", new IncomeBillDetail());
			model.addAttribute("listincomebill", inbill.finall());
			return  "/IncomeBillDetail/createDetaill";
		}
		
	}
	@PostMapping("/saveDetail")
	public String saveDeatail(Model model,@ModelAttribute("billDetail") IncomeBillDetail billdetail ) {
		FeeType fee = feetype.findById(billdetail.getIdfeetype().getIdFeetype());
		billdetail.setPrice(fee.getPrice()*billdetail.getQuantity());
		indetail.saveIncobillDetail(billdetail);
		model.addAttribute("idbill", billdetail.getIdIncomeBill().getIdIncomeBill());
		return "redirect:/showlistbill";
	}
}
