package com.fa.BlueHouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fa.BlueHouse.entities.form.Report;

public interface ReportRepository extends JpaRepository<Report, String> {
	
}
