package com.list.home.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.list.home.Model.Eccess;

@Repository
public interface EccessRepository extends JpaRepository<Eccess, Long> {
	
	Optional<Eccess> findTopByOrderByIdDesc();
}
