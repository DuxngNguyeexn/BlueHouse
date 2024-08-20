package com.fa.BlueHouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fa.BlueHouse.entities.Employee;
import com.fa.BlueHouse.entities.Notification;
import com.fa.BlueHouse.entities.Receiver;
import com.fa.BlueHouse.entities.Resident;
import com.fa.BlueHouse.repositories.NotiRepositories;
import com.fa.BlueHouse.repositories.ReceiverRepositories;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class NotiService {

	@Autowired
	private NotiRepositories notiRepo;

	@Autowired
	private ReceiverRepositories receiRepo;

	@Autowired
	private EmployeeService eService;

	@Autowired
	private ResidentService rService;

	public void saveNoti(Notification noti) {
		notiRepo.save(noti);
	}

	public void saveRecei(Receiver recei) {
		receiRepo.save(recei);
	}

	public List<Notification> findByIDSend(String id) {
		return receiRepo.findByIDSend(id);
	}

	public List<Notification> findByIDSeen(String id) {
		return receiRepo.findByIDSeen(id);
	}

	public Notification findNotiByID(String id) {
		return notiRepo.findById(id).orElse(null);
	}

	/**
	 * 
	 * @param choose       "All" || "AllEmployee" || "AllResident" || "Choosen"
	 * @param Notification notification
	 * @param Employee     employee sender
	 * @param Resident     resident sender
	 * @param String[]     list ID Receiver
	 */
	public void saveNotificationAndReceiver(String choose, Notification noti, Employee senderEmp, Resident senderResi,
			String[] listIDReceiver) {

		if (choose.equalsIgnoreCase("All")) {
			saveNoti(noti);
			saveAll(noti, senderEmp, senderResi, eService.allEmployee(), rService.findallResident());
		}
		if (choose.equalsIgnoreCase("AllEmployee")) {
			saveNoti(noti);
			saveAllEmp(noti, senderEmp, senderResi, eService.allEmployee());
		}
		if (choose.equalsIgnoreCase("AllResident")) {
			saveNoti(noti);
			saveAllResi(noti, senderEmp, senderResi, rService.findallResident());
		}
		if (choose.equalsIgnoreCase("Choosen")) {
			saveNoti(noti);
			saveChoosen(noti, senderEmp, senderResi, listIDReceiver);
		}
	}

	private void saveAll(Notification noti, Employee senderEmp, Resident senderResi, List<Employee> listEmp,
			List<Resident> listResi) {
		for (Employee e : listEmp) {
			saveRecei(new Receiver(noti, senderEmp, senderResi, e, null));
		}
		for (Resident e : listResi) {
			saveRecei(new Receiver(noti, senderEmp, senderResi, null, e));
		}
	}

	private void saveAllEmp(Notification noti, Employee senderEmp, Resident senderResi, List<Employee> listEmp) {
		for (Employee e : listEmp) {
			saveRecei(new Receiver(noti, senderEmp, senderResi, e, null));
		}
	}

	private void saveAllResi(Notification noti, Employee senderEmp, Resident senderResi, List<Resident> listResi) {
		for (Resident e : listResi) {
			saveRecei(new Receiver(noti, senderEmp, senderResi, null, e));
		}
	}

	private void saveChoosen(Notification noti, Employee senderEmp, Resident senderResi, String[] listID) {
		for (String e : listID) {
			Employee emp = eService.findById(e);
			Resident resi = rService.findById(e);
			saveRecei(new Receiver(noti, senderEmp, senderResi, emp, resi));
		}
	}

}
