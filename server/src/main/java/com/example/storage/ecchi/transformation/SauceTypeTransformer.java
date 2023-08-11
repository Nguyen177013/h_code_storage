package com.example.storage.ecchi.transformation;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.example.storage.ecchi.entity.Sauce;
import com.example.storage.ecchi.entity.SauceType;
import com.example.storage.ecchi.model.SauceTypeModel;
import com.example.storage.ecchi.repository.TypeRepository;

@Component
public class SauceTypeTransformer {

	@Autowired
	TypeRepository typeRepository;
	
	public List<SauceTypeModel> applyList(List<SauceType> entities){
		if(ObjectUtils.isEmpty(entities)) {
			return Collections.emptyList();
		}
		return entities.stream().map(this::apply).toList();

	}
	
	public List<SauceType> applyListModel(List<SauceTypeModel> entities, Sauce sauce){
		if(ObjectUtils.isEmpty(entities)) {
			return Collections.emptyList();
		}
		return entities.stream().map(sauceType -> {
			return applyModel(sauceType, sauce);
		}).toList();
	}
	
	public SauceTypeModel apply(SauceType entity) {
		SauceTypeModel model = new SauceTypeModel();
		model.setId(entity.getId());
		model.setSauceId(entity.getSauce().getId());
		model.setTypeId(entity.getType().getId());
		return model;
	}
	public SauceType applyModel(SauceTypeModel entity, Sauce sauce) {
		SauceType model = new SauceType();
		model.setId(entity.getId());
		model.setSauce(sauce);
		model.setType(typeRepository.findById(entity.getTypeId()).get());
		return model;
	}
}
