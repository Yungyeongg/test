package com.list.home.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.list.home.Model.Page;
import com.list.home.repository.PageRepository;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

@Service
public class CeofixServiceImpl implements CeofixService {
	
	// server保存経路
	private static final String UPLOAD_DIR = "C:/workplace/SIS/src/main/resources/static/img/sub/"; 
	// Webで接近可能経路
	private static final String FILE_URL_PATH = "/img/sub/"; 
	private final HttpSession session; 
    private final PageRepository pageRepository;
    
    public CeofixServiceImpl(PageRepository pageRepository, HttpSession session) {
        this.pageRepository = pageRepository;
        this.session = session;
    }
    
    @Transactional
    public void updateCeo(Long id, String title, String subtitle, String content, MultipartFile file)  {
        
    	Optional<Page>  optionalPage = pageRepository.findById(id);
    	
    	if(optionalPage.isEmpty()) {
    		throw new IllegalArgumentException(id + "なし");
    	}
        
    	Page page = optionalPage.get();
    	
    	page.setTitle(title);
    	page.setSubtitle(subtitle);
    	page.setContent(content);
    	
    	if (file != null && !file.isEmpty()) {
    		String fileName = file.getOriginalFilename();
    		
    		String uniqueFileName = System.currentTimeMillis() + "_" + fileName;
    		Path filePath = Paths.get(UPLOAD_DIR, uniqueFileName);
    		File uploadDir = new File(UPLOAD_DIR);
    		if(!uploadDir.exists()) {
    			uploadDir.mkdir();
    		}
    		
    		try {
    			file.transferTo(filePath.toFile());
    			page.setFile_path(FILE_URL_PATH + uniqueFileName);
    			page.setFile_name(uniqueFileName);
    		} catch (IOException e) {
    			e.printStackTrace();
    		}	
    	}
    	String adminId = (String) session.getAttribute("adminId");
    	page.setRenew(adminId);
        pageRepository.save(page);
    }
}
