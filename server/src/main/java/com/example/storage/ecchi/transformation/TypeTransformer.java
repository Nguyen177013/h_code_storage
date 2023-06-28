package com.example.storage.ecchi.transformation;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.example.storage.ecchi.entity.Type;
import com.example.storage.ecchi.model.SauceTypeModel;
import com.example.storage.ecchi.model.TypeModel;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TypeTransformer {
	
	private final SauceTypeTransformer sauceTypeTransformer;
	
	public List<TypeModel> applyList(List<Type> entities) {
		if(ObjectUtils.isEmpty(entities)) {
			return Collections.emptyList();
		}
		return entities.stream().map(this::apply).toList();
	}

	public TypeModel apply(Type entity) {
		TypeModel model = new TypeModel();
		List<SauceTypeModel> sauceTypes =  entity.getSauceType().stream().map(sauceTypeTransformer::apply).toList();
		model.setId(entity.getId());
		model.setName(entity.getName());
		model.setSauceType(sauceTypes);
		return model;
	}
}
