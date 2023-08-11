package com.example.storage.ecchi.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.example.storage.ecchi.model.SauceModel;

public interface SauceService {
	public Page<SauceModel> getSauce(Integer page, String sauceTypeId, Integer month, Integer year);
	
	public SauceModel getSauceById(int id);

	public boolean addSauce(SauceModel sauceModel);

	public boolean editSauce(int id, SauceModel sauceModel);

	public boolean deleteSauce(int id);
	
	public List<SauceModel> uploadImage(MultipartFile[] files);
}
