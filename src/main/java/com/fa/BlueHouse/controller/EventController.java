package com.fa.BlueHouse.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fa.BlueHouse.authen.model.AccountDTO;
import com.fa.BlueHouse.entities.Event;
import com.fa.BlueHouse.entities.Notification;
import com.fa.BlueHouse.services.EmployeeService;
import com.fa.BlueHouse.services.EventService;
import com.fa.BlueHouse.services.NotiService;
import com.fa.BlueHouse.services.ResidentService;

@Controller
@RequestMapping(path = "/event")
public class EventController {

	@Autowired
	private EventService eventService;

	@Autowired
	private ResidentService rService;

	@Autowired
	private EmployeeService eService;

	@Autowired
	private NotiService notiService;

	@GetMapping({ "/", "/list" })
	public String eventList(@RequestParam(name = "page", defaultValue = "1") int page, Model model,
			Principal principal) {
		AccountDTO auth = (AccountDTO) ((Authentication) principal).getPrincipal();

		int pageSize = 6;
		PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
		Page<Event> listEmployee = eventService.getAllEvent(auth.getId(), pageRequest);

		int totalPages;
		if (listEmployee.getTotalPages() < 1) {
			totalPages = 1;
		} else {
			totalPages = listEmployee.getTotalPages();
		}

		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("listEvent", listEmployee.getContent());

		return "Event/list";
	}

	@GetMapping("/add")
	public String confirm(Model model) {
		model.addAttribute("employee", eService.allEmployee());
		model.addAttribute("resident", rService.findallResident());
		model.addAttribute("event", new Event());
		return "Event/newEvent";
	}

	@PostMapping("/save")
	public String eventSave(@ModelAttribute("employee") Event event, Principal principal, Model model,
			@RequestParam("Choose") String Choose, @RequestParam("valueSend") String valueSend) {
		AccountDTO auth = (AccountDTO) ((Authentication) principal).getPrincipal();
		event.setIDOganizer(rService.findById(auth.getId()));

		String idEvent = LocalTime.now() + auth.getId() + event.getNameEvent().trim().replace(" ", "");
		event.setIdEvent(idEvent);

		eventService.saveEvent(event);

		Notification noti = new Notification();
		String[] listReceiver = valueSend.split(",");

		noti.setTitle("Event: " + event.getNameEvent());
		noti.setContentNoti("<figure class=\"table\"><table><tbody><tr><td><p><strong>Notice about event organization: "
				+ event.getNameEvent()
				+ "</strong></p></td></tr></tbody></table></figure><p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<strong> BLUE HOUSE PREMIUM APARTMENTS</strong><br>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<strong>Name: </strong>"
				+ auth.getName()
				+ "<br>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<strong> Phone: </strong>"
				+ auth.getPhoneNumber() + "<br> Please Announce the upcoming <strong>" + event.getNameEvent()
				+ "</strong> event. At <strong>" + event.getStartTime() + "</strong> on <strong>" + event.getStartDate()
				+ "</strong> Venue at <strong>" + event.getLocation()
				+ "</strong>. The Event takes place until <strong>" + event.getEndTime() + "</strong> on <strong>"
				+ event.getEndDate()
				+ ".</strong><br>&nbsp;</p><p>Looking forward to your presence. Please confirm your participation soon and stay tuned for information.</p><p><br>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;Thank you and Warmest Regards.</p><p>&nbsp;</p>");
		noti.setDate(LocalDate.now());
		noti.setTime(LocalTime.now());
		noti.setTypeNote("KeyEvent~" + idEvent);

		notiService.saveNotificationAndReceiver(Choose, noti, principal, listReceiver);

		return "redirect:list";
	}

}
