package com.example.storage.ecchi.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.storage.ecchi.model.SauceModel;

public interface SauceService {
	List<SauceModel> getSauce(Integer no);
	
	List<SauceModel> getImage();

	public SauceModel getSauceById(int id);

	public void addSauce(SauceModel sauceModel);

	public void editSauce(int id, SauceModel sauceModel);

	public void deleteSauce(int id);
	
	public boolean uploadImage(MultipartFile[] files);
}
