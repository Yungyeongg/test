package com.list.home.service;

import org.springframework.web.multipart.MultipartFile;

public interface CeofixService {
	
	public void updateCeo(Long id, String title, String subtitle, String content, MultipartFile file); 
}
