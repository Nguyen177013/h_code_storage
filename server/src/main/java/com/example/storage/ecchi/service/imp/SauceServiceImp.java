package com.example.storage.ecchi.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.example.storage.ecchi.model.SauceModel;
import com.example.storage.ecchi.repository.SauceRepository;
import com.example.storage.ecchi.service.SauceService;

public class SauceServiceImp implements SauceService {

	@Autowired
	SauceRepository sauceRepository;

	@Override
	public Page<SauceModel> getSauce() {
		return null;
	}

	@Override
	public void adddSauce(SauceModel sauceModel) {
		// TODO Auto-generated method stub

	}

	@Override
	public void editSauce(SauceModel sauceModel) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteSauce(SauceModel sauceModel) {
		// TODO Auto-generated method stub

	}

}
