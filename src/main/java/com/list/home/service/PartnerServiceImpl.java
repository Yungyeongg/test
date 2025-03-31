package com.list.home.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.list.home.Model.Partner;
import com.list.home.repository.PartnerRepository;

import java.nio.file.Path;
import jakarta.servlet.http.HttpSession;

@Service
public class PartnerServiceImpl implements PartnerService{
	
	// server保存経路
	private static final String UPLOAD_DIR = "C:/workplace/SIS/src/main/resources/static/img/sub/"; 
	// Webで接近可能経路
	private static final String FILE_URL_PATH = "/img/sub/"; 
	private final HttpSession session; 
	private PartnerRepository partnerRepository;
	public PartnerServiceImpl(PartnerRepository partnerRepository, HttpSession session) {
		this.partnerRepository = partnerRepository;
		this.session = session;
	}
	
	public void savePartners(List<Partner> partners, MultipartFile[] files) {
		
		  // directory確認及び生成(反復文外で実行)
        Path uploadPath = Paths.get(UPLOAD_DIR);
        if (!Files.exists(uploadPath)) {
            try {
                Files.createDirectories(uploadPath);
            } catch (IOException e) {
                System.err.println("upload　directory生成失敗: " + UPLOAD_DIR);
                e.printStackTrace();
                return; // directory生成失敗時中断
            }
        }
        List<Partner> partnerList = new ArrayList<>(partners);
        for (int i = 0; i < partners.size(); i++) {
            Partner partner = partnerList.get(i);

            // ファイルが存在する場合だけ保存
            if (files != null && files.length > i && !files[i].isEmpty()) {
                try {
                    //　unique名前
                    String fileName = System.currentTimeMillis() + "_" + files[i].getOriginalFilename();
                    Path filePath = Paths.get(UPLOAD_DIR, fileName);

                    // ファイル保存
                    Files.copy(files[i].getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

                    // Web経路
                    partner.setFile_path(FILE_URL_PATH + fileName);
                    partner.setFile_name(fileName);

                } catch (IOException e) {
                    System.err.println("ファイル保存中ミス: " + e.getMessage());
                    e.printStackTrace();
                }
            }

            // 管理者ID設定
            String adminId = (String) session.getAttribute("adminId");
            partner.setRenew(adminId);

            // 保存
            partnerRepository.save(partner);
        }
			}
		    				    	
	public List<Partner>getPartners() {
		return partnerRepository.findAll();
	}
	public Optional<Partner>getPartnerById(Long id) {
		return partnerRepository.findById(id);
	}

}
