package com.fa.BlueHouse.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fa.BlueHouse.entities.Notification;
import com.fa.BlueHouse.entities.Receiver;

public interface ReceiverRepositories extends JpaRepository<Receiver, Integer> {
	@Query("SELECT DISTINCT recei.notification FROM Receiver recei WHERE recei.senderEmp.employeeID = :idEmp OR recei.senderResi.idResident = :idEmp")
	List<Notification> findByIDSend(@Param("idEmp") String idEmp);
	
	@Query("SELECT DISTINCT recei.notification FROM Receiver recei WHERE recei.receiverEmp.employeeID = :idEmp OR recei.receiverResi.idResident = :idEmp")
	List<Notification> findByIDSeen(@Param("idEmp") String idEmp);
}
