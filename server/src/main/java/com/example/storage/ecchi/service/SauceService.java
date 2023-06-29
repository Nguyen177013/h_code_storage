package com.example.storage.ecchi.service;

import java.util.List;

import com.example.storage.ecchi.model.SauceModel;

public interface SauceService {
	List<SauceModel> getSauce(Integer no);

	public SauceModel getSauceById(int id);

	public void addSauce(SauceModel sauceModel);

	public void editSauce(int id, SauceModel sauceModel);

	public void deleteSauce(int id);
}
