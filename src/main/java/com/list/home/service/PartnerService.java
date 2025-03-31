package com.list.home.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.list.home.Model.Partner;

public interface PartnerService {

	public void savePartners(List<Partner> partners, MultipartFile[] files);
	public List<Partner> getPartners();
	public Optional<Partner>getPartnerById(Long id);
}
