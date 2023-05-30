package com.example.storage.ecchi.service;

import org.springframework.data.domain.Page;

import com.example.storage.ecchi.model.SauceModel;

public interface SauceService {
	Page<SauceModel> getSauce();
	
	public void adddSauce(SauceModel sauceModel);
	
	public void editSauce(SauceModel sauceModel);
	
	public void deleteSauce(SauceModel sauceModel);
}
