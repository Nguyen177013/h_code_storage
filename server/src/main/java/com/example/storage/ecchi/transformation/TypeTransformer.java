package com.example.storage.ecchi.transformation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.storage.ecchi.entity.Type;
import com.example.storage.ecchi.model.TypeModel;

@Component
public class TypeTransformer {
	public List<TypeModel> typeEntityToModel(List<Type> entity){
		List<TypeModel> typeModels = new ArrayList<>();
		for(Type type : entity) {
			typeModels.add(TypeModel.builder().name(type.getName()).build());
		}
		return typeModels;
	}
}
