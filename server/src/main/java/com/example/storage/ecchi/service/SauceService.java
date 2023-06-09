package com.example.storage.ecchi.service;

import org.springframework.data.domain.Page;

import com.example.storage.ecchi.model.SauceModel;

public interface SauceService {
	Page<SauceModel> getSauce();
	
	public SauceModel getSauceById(int id);
	
	public void addSauce(SauceModel sauceModel);
	
	public void editSauce(int id, SauceModel sauceModel);
	
	public void deleteSauce(int id);
}
