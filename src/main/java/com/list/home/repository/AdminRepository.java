package com.list.home.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.list.home.Model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{

	 Optional<Admin> findById(String id); // Optional: 明示的なnull処理
	 
	 @Query("SELECT a FROM Admin a WHERE a.mail IS NOT NULL")
	 List<Admin> findAllMailsNotNull(); //全ての管理者のemailを返還する
}
