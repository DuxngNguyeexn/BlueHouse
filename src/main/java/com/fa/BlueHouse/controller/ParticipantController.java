package com.fa.BlueHouse.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fa.BlueHouse.authen.model.AccountDTO;
import com.fa.BlueHouse.entities.Employee;
import com.fa.BlueHouse.entities.Event;
import com.fa.BlueHouse.entities.Notification;
import com.fa.BlueHouse.entities.Participants;
import com.fa.BlueHouse.entities.Resident;
import com.fa.BlueHouse.services.EmployeeService;
import com.fa.BlueHouse.services.EventService;
import com.fa.BlueHouse.services.NotiService;
import com.fa.BlueHouse.services.ParticipantService;
import com.fa.BlueHouse.services.ResidentService;

@Controller
@RequestMapping(path = "/event")
public class ParticipantController {

	@Autowired
	private ParticipantService partiService;

	@Autowired
	private EventService eventService;

	@Autowired
	private ResidentService rService;

	@Autowired
	private EmployeeService eService;

	@Autowired
	private NotiService notiService;

	@GetMapping("/confirm")
	public String eventAdd(Model model, @RequestParam("eventID") String eventID, Principal principal,
			@RequestParam(name = "idNoti", defaultValue = "") String idNoti) {
		AccountDTO auth = (AccountDTO) ((Authentication) principal).getPrincipal();
		Employee partiEmp = eService.findById(auth.getId());
		Resident partiResi = rService.findById(auth.getId());

		Event event = eventService.findById(eventID);
		event.setNumberOfParticipants(event.getNumberOfParticipants() + 1);

		Participants parti = new Participants(event, partiEmp, partiResi, "participants", null);
		partiService.saveParticipant(parti);

		Notification noti = notiService.findNotiByID(idNoti);
		noti.setTypeNote(null);
		notiService.saveNoti(noti);

		return "redirect:/notification/listSeen";
	}

}
