package com.fa.BlueHouse.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.fa.BlueHouse.entities.RegisterForResidence;

public interface RegisterForResidenceRepository extends JpaRepository<RegisterForResidence, String>{

	@Query("SELECT re FROM RegisterForResidence re where re.idResidence LIKE %:seacrch% or re.relationshipWithHomeowner LIKE %:seacrch%  or re.type LIKE %:seacrch%  or re.phone LIKE %:seacrch% ")
	Page<RegisterForResidence> searchRegisterForResidence(@Param("seacrch")String seacrch, Pageable pageable);
}
