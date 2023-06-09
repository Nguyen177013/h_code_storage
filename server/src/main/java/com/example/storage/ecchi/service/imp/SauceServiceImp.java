package com.example.storage.ecchi.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.example.storage.ecchi.entity.Sauce;
import com.example.storage.ecchi.model.SauceModel;
import com.example.storage.ecchi.repository.SauceRepository;
import com.example.storage.ecchi.service.SauceService;
import com.example.storage.ecchi.transformation.SauceTransformer;

public class SauceServiceImp implements SauceService {

	@Autowired
	SauceRepository sauceRepository;

	SauceTransformer sauceTransfomer;

	@Override
	public Page<SauceModel> getSauce() {
		return null;
	}

	@Override
	public void addSauce(SauceModel sauceModel) {
		Sauce sauce = sauceTransfomer.apply(sauceModel);
		sauceRepository.save(sauce);
	}

	@Override
	public void editSauce(int id, SauceModel sauceModel) {
		Sauce sauce = sauceTransfomer.apply(sauceModel);
		sauce.setId(id);
		sauceRepository.save(sauce);
	}

	@Override
	public void deleteSauce(int id) {
		sauceRepository.deleteById(id);
	}

	@Override
	public SauceModel getSauceById(int id) {
		return sauceTransfomer.sauceEntityToModel(sauceRepository.findById(id).orElseThrow());
	}

}
