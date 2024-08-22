package com.fa.BlueHouse.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fa.BlueHouse.entities.IncomeBillDetail;

public interface IncomeBillDetailRepositories extends JpaRepository<IncomeBillDetail, String>{
	@Query("FROM IncomeBillDetail Where idIncomeBill.idIncomeBill = :idBill")
	public Page<IncomeBillDetail> findByIdBill(String idBill, Pageable page);
	@Query("FROM IncomeBillDetail ")
	public Page<IncomeBillDetail> findBill( Pageable page);
	@Query("FROM IncomeBillDetail where idbilldetail LIKE %:seacrch% or idIncomeBill.idIncomeBill LIKE %:seacrch% or idfeetype.nameFeetype LIKE %:seacrch%")
	public Page<IncomeBillDetail> searchDetail(String seacrch , Pageable pageable);
	@Query("FROM IncomeBillDetail where (idbilldetail LIKE %:seacrch%  or idfeetype.nameFeetype LIKE %:seacrch%) and idIncomeBill.idIncomeBill = :idbill")
	public Page<IncomeBillDetail> searchDetail(String seacrch ,String idbill, Pageable pageable);
	@Query("SELECT MAX(i.idbilldetail) FROM IncomeBillDetail i")
    String findMaxId();
}
