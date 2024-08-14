package com.fa.BlueHouse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fa.BlueHouse.entities.form.Report;
import com.fa.BlueHouse.repositories.ReportRepository;

@Service
public class ReportService {
	@Autowired
	ReportRepository reportRepository;
	public Page<Report> showAll(Pageable pageable){
		return reportRepository.findAll(pageable);
	}
}
