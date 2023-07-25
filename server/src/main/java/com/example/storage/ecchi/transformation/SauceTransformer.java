
package com.example.storage.ecchi.transformation;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.example.storage.ecchi.entity.Sauce;
import com.example.storage.ecchi.model.SauceModel;
import com.example.storage.ecchi.model.SauceTypeModel;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SauceTransformer {

	private final SauceTypeTransformer sauceTypeTransformer;


	public List<SauceModel> applyList(List<Sauce> entities) {
		if (ObjectUtils.isEmpty(entities)) {
			return Collections.emptyList();
		}
		return entities.stream().map(this::apply).toList();
	}

	public SauceModel apply(Sauce entity) {
		SauceModel model = new SauceModel();
		List<SauceTypeModel> sauceTypes = entity.getSauceType().stream().map(sauceTypeTransformer::apply).toList();
		model.setId(entity.getId());
		model.setName(entity.getName());
		if(!(entity.getAuthor() == null)) {
			model.setAuthorId(entity.getAuthor().getId());			
			model.setAuthorName(entity.getAuthor().getName());
		}
		model.setSauceImage(entity.getSauceImage());
		model.setSauceUrl(entity.getSauceUrl());
		model.setSauceType(sauceTypes);
		return model;
	}
}
