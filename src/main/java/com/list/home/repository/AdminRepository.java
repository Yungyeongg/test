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
	 
	//JPQL(Java Persistence Query Language）文法です
	// select a -> Admin entityオブジェクト自体を持ち来る
	// From Admin a -> Admin entityを　a　という　aliasで指定
	// WHERE a.mail IS NOT NULL -> mail値がNULLじゃないデータだけfiltering
	 @Query("SELECT a FROM Admin a WHERE a.mail IS NOT NULL") 
	 List<Admin> findAllMailsNotNull(); //nullがない全ての管理者のemailを返還する
	 //List<Admin> admins = adminRepository.findAllAdminsWithEmail();
	 //for (Admin admin : admins) {
	 //	    System.out.println(admin.getName()); // Admin entityのfield出力可能
	 //	}
}
