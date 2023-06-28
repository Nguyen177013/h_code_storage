package com.example.storage.ecchi.transformation;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.example.storage.ecchi.entity.SauceHistory;
import com.example.storage.ecchi.model.SauceHistoryModel;

@Component
public class SauceHistoryTransformer {
	
	public List<SauceHistoryModel> applyList(List<SauceHistory> entities){
		if (ObjectUtils.isEmpty(entities)) {
			return Collections.emptyList();
		}
		return entities.stream().map(this::apply).toList();
	}
	
	public SauceHistoryModel apply(SauceHistory entity) {
		SauceHistoryModel model = new SauceHistoryModel();
		model.setId(entity.getId());
		model.setDateUpload(entity.getDateUpload());
		model.setSauceId(entity.getSauce().getId());
		model.setSauceName(entity.getSauce().getName());
		return model;
	}
}
