package com.example.storage.ecchi.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.storage.ecchi.model.SauceModel;
import com.example.storage.ecchi.repository.SauceRepository;
import com.example.storage.ecchi.service.SauceService;
import com.example.storage.ecchi.transformation.SauceTransformer;

@Service
public class SauceServiceImp implements SauceService {

	@Autowired
	SauceRepository sauceRepository;

	@Autowired
	SauceTransformer transformer;

	@Override
	public Page<SauceModel> getSauce(Integer no, Integer limit, String sortBy) {
		Sort sort = Sort.by(sortBy);
		return sauceRepository.getAllSauce(PageRequest.of(no, limit, sort)).map(ele -> transformer.apply(ele));
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
