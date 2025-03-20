package com.list.home.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.list.home.Model.Page;
import com.list.home.repository.PageRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class CeofixService {
	
	private static final String UPLOAD_DIR = "C:/workplace/SIS/src/main/resoures/static/img/sub/"; //ファイル保存経路
	private final PageRepository pageRepository;
    private final HttpSession session; // 세션 사용
    
    public CeofixService(PageRepository pageRepository, HttpSession session) {
        this.pageRepository = pageRepository;
        this.session = session;
    }
    
    public Page findPage(Long id) {
    	return pageRepository.findById(id).orElse(new Page()); 
    }
    
    public Page saveOrUpdateCeo(Long id, String title, String subtitle, String content, MultipartFile file) throws Exception {
        
    	String adminId = (String) session.getAttribute("adminId"); // 세션에서 어드민 ID 가져오기
        
    	if (adminId == null) {
            throw new RuntimeException("관리자 세션 정보가 없습니다.");
        }

        Page page;
        if (id == null) { // 새 글 등록
        	page = new Page();
        	page.setRegist(adminId);
        	page.setRegist_date(LocalDateTime.now());
        } else { // 기존 글 수정
            page = pageRepository.findById(id).orElseThrow(() -> new RuntimeException("既存の情報がないです。"));
        }

        // 파일 저장
        if (file != null && !file.isEmpty()) {
            // 파일 이름 생성 (현재시간 + 원본 파일명)
        	String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path file_path = Paths.get(UPLOAD_DIR + fileName);
            //파일 저장
            Files.write(file_path, file.getBytes());

            page.setFile_name(fileName);
            page.setFile_path("/img/sub/" + fileName); //상대경로로 저장
            page.setImage_name("/img/sub/" + fileName); //클라이언트에서 접근
        }

        // 내용 업데이트
        page.setTitle(title);
        page.setSubtitle(subtitle);
        page.setContent(content);
        page.setRenew(adminId);
        page.setRenew_date(LocalDateTime.now());

        return pageRepository.save(page);
    }
}
