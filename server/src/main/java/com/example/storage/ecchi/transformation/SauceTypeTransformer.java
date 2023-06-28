package com.example.storage.ecchi.transformation;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.example.storage.ecchi.entity.SauceType;
import com.example.storage.ecchi.model.SauceTypeModel;

@Component
public class SauceTypeTransformer {

	public List<SauceTypeModel> applyList(List<SauceType> entities){
		if(ObjectUtils.isEmpty(entities)) {
			return Collections.emptyList();
		}
		return entities.stream().map(this::apply).toList();

	}
	
	public SauceTypeModel apply(SauceType entity) {
		SauceTypeModel model = new SauceTypeModel();
		model.setId(entity.getId());
		model.setSauceId(entity.getSauce().getId());
		model.setTypeId(entity.getType().getId());
		return null;
	}
}
