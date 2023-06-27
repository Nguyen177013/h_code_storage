package com.example.storage.ecchi.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.storage.ecchi.model.SauceModel;
import com.example.storage.ecchi.repository.SauceRepository;
import com.example.storage.ecchi.service.SauceService;

@Service
public class SauceServiceImp implements SauceService {

	@Autowired
	SauceRepository sauceRepository;


	@Override
	public Page<SauceModel> getSauce() {
		return null;
	}

	@Override
	public void addSauce(SauceModel sauceModel) {
	}

	@Override
	public void editSauce(int id, SauceModel sauceModel) {
	}

	@Override
	public void deleteSauce(int id) {
		sauceRepository.deleteById(id);
	}

	@Override
	public SauceModel getSauceById(int id) {
		return null;
	}

}
