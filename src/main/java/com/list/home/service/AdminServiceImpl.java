package com.list.home.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.list.home.Model.Admin;
import com.list.home.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {
	
	private final AdminRepository adminRepository;
	
	public AdminServiceImpl(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}
	
	public boolean authenticate(String id, String password) {
		Optional<Admin> admin = adminRepository.findById(id);
        return admin.isPresent() && admin.get().getPassword().equals(password);
        //get():Optionalオブジェクトで値を出す時method
	}
}
