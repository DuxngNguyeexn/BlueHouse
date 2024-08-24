package com.fa.BlueHouse.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fa.BlueHouse.entities.Notification;
import com.fa.BlueHouse.entities.Receiver;

public interface ReceiverRepositories extends JpaRepository<Receiver, Integer> {

	@Query("SELECT DISTINCT recei.notification FROM Receiver recei WHERE recei.senderEmp.employeeID = :idEmp OR recei.senderResi.idResident = :idEmp")
	List<Notification> findByIDSend(@Param("idEmp") String idEmp);
	
	@Query("SELECT DISTINCT recei FROM Receiver recei WHERE (recei.receiverEmp.employeeID = :idEmp OR recei.receiverResi.idResident = :idEmp) AND recei.status = 0 ")
	List<Receiver> findNotiUnSeen(@Param("idEmp") String idEmp);

	@Query("SELECT n FROM Notification n WHERE n.id IN (" +
		       "SELECT DISTINCT recei.notification.id FROM Receiver recei " +
		       "WHERE recei.senderEmp.employeeID = :idEmp OR recei.senderResi.idResident = :idEmp)")
	Page<Notification> findByIDSend(@Param("idEmp") String idEmp, Pageable pageable);

	@Query("SELECT DISTINCT recei FROM Receiver recei WHERE recei.receiverEmp.employeeID = :idEmp OR recei.receiverResi.idResident = :idEmp ORDER BY recei.status ASC")
	Page<Receiver> findByIDSeen(@Param("idEmp") String idEmp, Pageable pageable);
}
