package com.example.storage.ecchi.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.storage.ecchi.model.SauceModel;

public interface SauceService {
	public List<SauceModel> getSauce(Integer page, String sauceTypeId);
	
	public SauceModel getSauceById(int id);

	public void addSauce(SauceModel sauceModel);

	public void editSauce(int id, SauceModel sauceModel);

	public boolean deleteSauce(int id);
	
	public List<SauceModel> uploadImage(MultipartFile[] files);
}
