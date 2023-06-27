package com.example.storage.ecchi.service.imp;

import java.util.List;

import com.example.storage.ecchi.model.SauceTypeModel;
import com.example.storage.ecchi.repository.SauceTypeRepository;
import com.example.storage.ecchi.service.SauceTypeService;
import com.example.storage.ecchi.transformation.SauceTypeTransformer;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SauceTypeServiceImp implements SauceTypeService{
	
	SauceTypeRepository repository;
	
	SauceTypeTransformer transformer;
	
	@Override
	public List<SauceTypeModel> getAllSauceType() {
		return transformer.applyList(repository.findAll());
	}

}
