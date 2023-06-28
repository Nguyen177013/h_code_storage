package com.example.storage.ecchi.service.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.storage.ecchi.model.SauceHistoryModel;
import com.example.storage.ecchi.repository.SauceHistoryRepository;
import com.example.storage.ecchi.service.SauceHistoryService;
import com.example.storage.ecchi.transformation.SauceHistoryTransformer;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SauceHistoryServiceImp implements SauceHistoryService{

	SauceHistoryRepository repository;
	
	SauceHistoryTransformer transformer;
	
	@Override
	public List<SauceHistoryModel> getAllSauceHistory() {
		return transformer.applyList(repository.findAll());
	}

}
