package com.list.home.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.list.home.Model.Partner;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {
	
	    Optional <Partner> findById(Long id);
}
