package com.list.home.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.list.home.Model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{

	 Optional<Admin> findById(String id); // Optional: 明示的なnull処理
}
