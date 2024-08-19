package com.fa.BlueHouse.controller;

import java.security.Principal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fa.BlueHouse.authen.model.AccountDTO;
import com.fa.BlueHouse.entities.FeeType;
import com.fa.BlueHouse.entities.IncomeBill;
import com.fa.BlueHouse.services.ApartmentService;
import com.fa.BlueHouse.services.EmployeeService;
import com.fa.BlueHouse.services.FeetypeService;
import com.fa.BlueHouse.services.IncomeBillService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/IncomeBill")
public class IncomeBillController {

	@Autowired
	private FeetypeService feetype;
	@Autowired
	private IncomeBillService inbill;
	@Autowired
	private ApartmentService apart;
	@Autowired
	private EmployeeService emp;
	@RequestMapping("/showfeetype")
	public String showlistFeetype(Model model, @RequestParam(name = "page", defaultValue = "1") int page) {
		int pageSize = 6;
		PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
		Page<FeeType> listfeetype = feetype.findallpageFeetype(pageRequest);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", listfeetype.getTotalPages());
		model.addAttribute("listfeetype", listfeetype.getContent());
		return "Feetype/listFeetype";
	}
	@GetMapping("/createFeetype")
	public String createFeetype(Model model) {
		model.addAttribute("feetype", new FeeType());
		return "Feetype/createFeetype";
	}
	
	@PostMapping("/savefeetype")
	public String saveFeetype(Model model,@Valid @ModelAttribute("feetype") FeeType fee, BindingResult result) {
		if(result.hasErrors()) {
			return "Feetype/listFeetype";
		}else {
        feetype.saveFeetype(fee);
			return "redirect:/IncomeBill/showfeetype";
		}
	}
	@GetMapping("/showlistapratmentbill")
	public String showlistApartmentBill(Model model, @RequestParam(name = "page", defaultValue = "1") int page, @RequestParam("idApartment") String idApartment) {
		int pageSize = 6;
		PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
		Page<IncomeBill> listApartmentBill = inbill.findApartmentBill(idApartment, pageRequest);
		model.addAttribute("apartment", apart.findById(idApartment));
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", listApartmentBill.getTotalPages());
		model.addAttribute("listapartmentbill", listApartmentBill.getContent());
		return "/IncomeBill/listIncomebill";
	}
	@GetMapping("/showlistbill")
	public String showlistBill(Model model, @RequestParam(name = "page", defaultValue = "1") int page) {
		int pageSize = 6;
		PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
		Page<IncomeBill> listApartmentBill = inbill.findAllbill( pageRequest);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", listApartmentBill.getTotalPages());
		model.addAttribute("listapartmentbill", listApartmentBill.getContent());
		return "/IncomeBill/listAllBill";
	}
	@GetMapping("/createapartmentbill")
	public String createApartBill(Model model,@RequestParam(name = "idapartment", defaultValue = "#{null}" )String id ) {
		if(id != null) {
			model.addAttribute("incomebill", new IncomeBill(apart.findById(id)));
			return "/IncomeBill/createApartmentBill";
		}else {
			model.addAttribute("incomebill", new IncomeBill());
			model.addAttribute("listapart", apart.allApartments());
			return  "/IncomeBill/createBill";
		}
		
	}
	@PostMapping("/saveapartmentbill")
	public String saveApartmentBill(Model model,@ModelAttribute("incomebill") IncomeBill incobill ) {
		inbill.saveIncobill(incobill);
		return "redirect:/IncomeBill/showlistapratmentbill?idApartment=" + incobill.getIdApartment().getIdApartment();
	} 
	@GetMapping("/searchIncobill")
	public String searchIncomeBill(@RequestParam(name = "searchKeyword", defaultValue = "") String keyword, Model model,
			@RequestParam(name = "page", defaultValue = "1") int page) {
		int pageSize = 6;
		PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
		Page<IncomeBill> listApartmentBill = inbill.searchIncomeBill(keyword, pageRequest);
		model.addAttribute("currentPage", page);
		int totalPages ;
		if(listApartmentBill.getTotalPages() < 1) {
			totalPages = 1 ;
		}else {
			totalPages = listApartmentBill.getTotalPages();
		}
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("searchKeyword", keyword);
		model.addAttribute("listapartmentbill", listApartmentBill.getContent());
		return "/IncomeBill/listAllBill";
	}
	
	@GetMapping("/paybill")
	public String payBill(Principal principal, Model model, @RequestParam("idbill")String idbill) {
		AccountDTO thongTin = (AccountDTO) ((Authentication) principal).getPrincipal();
		IncomeBill incomebill = inbill.findById(idbill);
		incomebill.setStatus("Bill Paid");
		incomebill.setIdEmployee(emp.findById(thongTin.getId()));
		incomebill.setPaymentDate(LocalDate.now());
		inbill.saveIncobill(incomebill);
		return "redirect:/IncomeBill/showlistapratmentbill?idApartment=" + incomebill.getIdApartment().getIdApartment();

	}
}
