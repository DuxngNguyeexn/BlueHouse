package com.fa.BlueHouse.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fa.BlueHouse.entities.Assets;
import com.fa.BlueHouse.entities.IdAssets;

public interface AssetRepository extends JpaRepository<Assets, IdAssets> {
	   @Query("SELECT MAX(a.id.idAsset) FROM Assets a")
	    String findMaxId();
	   @Query("SELECT a FROM Assets a WHERE a.name LIKE %:keyword% OR a.id.idAsset LIKE %:keyword% OR a.id.location LIKE %:keyword% ")
	   Page<Assets> findByKeyword(@Param("keyword") String keyword , Pageable pageable);
}
