package com.fa.BlueHouse.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fa.BlueHouse.authen.model.AccountDTO;
import com.fa.BlueHouse.entities.Notification;
import com.fa.BlueHouse.services.EmployeeService;
import com.fa.BlueHouse.services.NotiService;
import com.fa.BlueHouse.services.ResidentService;

@Controller
@RequestMapping(path = "notification")
public class NotiController {
	private final String uploadDirRequest = "E:\\imgNoti";
	private Notification notificationSend;

	@Autowired
	private NotiService notiService;

	@Autowired
	private EmployeeService eService;

	@Autowired
	private ResidentService rService;

	@GetMapping("viewDetail")
	public String viewDetail(@RequestParam(name = "idNoti", defaultValue = "") String idNoti, Model model) {

		Notification listNoti = notiService.findNotiByID("R0132024-08-2013:08:14.975624300");

		model.addAttribute("post", listNoti);

		return "Notifications/viewNoti";
	}

	@GetMapping("listSeen")
	public String listSeen(Principal principal, Model model) {
		AccountDTO auth = (AccountDTO) ((Authentication) principal).getPrincipal();

		List<Notification> listNoti = notiService.findByIDSeen(auth.getId());

		for (Notification e : listNoti) {
			System.err.println(e.getNotificationCode());
		}

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
	public String save(Model model, @ModelAttribute("noti") Notification noti,
			@RequestParam("imgNotification") MultipartFile file, RedirectAttributes redirectAttributes) {

		if (file != null) {
			try {
				String fileName = file.getOriginalFilename();
				Path path = Paths.get(uploadDirRequest + File.separator + fileName);
				Files.write(path, file.getBytes());
				noti.setAttachment(fileName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		noti.setDate(LocalDate.now());
		noti.setTime(LocalTime.now());

		notificationSend = noti;

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
		
		String[] listReceiver = listRecei.split(",");

		notiService.saveNotificationAndReceiver(choose, notificationSend, principal, listReceiver);

		return "redirect:add";
	}

}
