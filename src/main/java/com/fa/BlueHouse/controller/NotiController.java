package com.fa.BlueHouse.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fa.BlueHouse.authen.model.AccountDTO;
import com.fa.BlueHouse.entities.Employee;
import com.fa.BlueHouse.entities.Notification;
import com.fa.BlueHouse.entities.Receiver;
import com.fa.BlueHouse.entities.Resident;
import com.fa.BlueHouse.services.EmployeeService;
import com.fa.BlueHouse.services.NotiService;
import com.fa.BlueHouse.services.ResidentService;

@Controller
@RequestMapping(path = "notification")
public class NotiController {

	@Autowired
	private NotiService notiService;

	@Autowired
	private EmployeeService eService;

	@Autowired
	private ResidentService rService;

	@GetMapping("listSeen")
	public String listSeen() {
		return "Notifications/listSeenNoti";
	}

	@GetMapping("listSend")
	public String listSend(Principal principal, Model model) {

		AccountDTO auth = (AccountDTO) ((Authentication) principal).getPrincipal();

		List<Notification> listNoti = notiService.findByIDSend(auth.getId());

		for (Notification e : listNoti) {
			System.err.println(e.getNotificationCode());
		}

		return "Notifications/listSendNoti";
	}

	private Notification notificationSend;

	/**
	 * Điều hướng tới trang tạo noti
	 * 
	 * @return model.addAttribute("Notification", new Notification());
	 */
	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("Notification", new Notification());
		return "Notifications/createNoti";
	}

	/**
	 * Chuẩn bị một noti để lưu
	 * 
	 * @return notificationSend
	 */
	@PostMapping("save")
	public String save(Model model, @ModelAttribute("noti") Notification noti, Principal principal) {
		AccountDTO thongTin = (AccountDTO) ((Authentication) principal).getPrincipal();
		noti.setDate(LocalDate.now());
		noti.setTime(LocalTime.now());
		notificationSend = noti;

		String id = thongTin.getId() + notificationSend.getDate() + notificationSend.getTime();
		notificationSend.setNotificationCode(id);

		return "redirect:sending";
	}

	/**
	 * Điều hướng tới trang thêm người nhận
	 * 
	 * @return
	 */
	@GetMapping("sending")
	public String sending(Model model) {
		model.addAttribute("employee", eService.allEmployee());
		model.addAttribute("resident", rService.findallResident());
		return "Notifications/choosenSelect";
	}

	/**
	 * Chuẩn bị đối tượng để lưu Lưu vào database
	 * 
	 * @return
	 */
	@GetMapping("saveReceiver")
	public String saveReceiver(Principal principal,
			@RequestParam(name = "ListValue", defaultValue = "") String listRecei,
			@RequestParam(name = "choose", defaultValue = "0") String choose) {

		AccountDTO thongTin = (AccountDTO) ((Authentication) principal).getPrincipal();

		String[] listReceiver = listRecei.split(",");

		Employee senderEmp = eService.findById(thongTin.getId());
		Resident senderResi = rService.findById(thongTin.getId());

		if (choose.equalsIgnoreCase("All")) {
			notiService.saveNoti(notificationSend);
			saveAll(notificationSend, senderEmp, senderResi, eService.allEmployee(), rService.findallResident());
		}
		if (choose.equalsIgnoreCase("AllEmployee")) {
			notiService.saveNoti(notificationSend);
			saveAllEmp(notificationSend, senderEmp, senderResi, eService.allEmployee());
		}
		if (choose.equalsIgnoreCase("AllResident")) {
			notiService.saveNoti(notificationSend);
			saveAllResi(notificationSend, senderEmp, senderResi, rService.findallResident());
		}
		if (choose.equalsIgnoreCase("Choosen")) {
			notiService.saveNoti(notificationSend);
			saveChoosen(notificationSend, senderEmp, senderResi, listReceiver);
		}

		return "redirect:add";
	}

	private void saveAll(Notification noti, Employee senderEmp, Resident senderResi, List<Employee> listEmp,
			List<Resident> listResi) {
		for (Employee e : listEmp) {
			notiService.saveRecei(new Receiver(noti, senderEmp, senderResi, e, null));
		}
		for (Resident e : listResi) {
			notiService.saveRecei(new Receiver(noti, senderEmp, senderResi, null, e));
		}
	}

	private void saveAllEmp(Notification noti, Employee senderEmp, Resident senderResi, List<Employee> listEmp) {
		for (Employee e : listEmp) {
			notiService.saveRecei(new Receiver(noti, senderEmp, senderResi, e, null));
		}
	}

	private void saveAllResi(Notification noti, Employee senderEmp, Resident senderResi, List<Resident> listResi) {
		for (Resident e : listResi) {
			notiService.saveRecei(new Receiver(noti, senderEmp, senderResi, null, e));
		}
	}

	private void saveChoosen(Notification noti, Employee senderEmp, Resident senderResi, String[] listID) {
		for (String e : listID) {
			Employee emp = eService.findById(e);
			Resident resi = rService.findById(e);
			notiService.saveRecei(new Receiver(noti, senderEmp, senderResi, emp, resi));
		}
	}

}
