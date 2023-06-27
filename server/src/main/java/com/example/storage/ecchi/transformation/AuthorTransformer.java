package com.example.storage.ecchi.transformation;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.example.storage.ecchi.entity.Author;
import com.example.storage.ecchi.model.AuthorModel;
import com.example.storage.ecchi.model.SauceModel;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AuthorTransformer {
	
	private final SauceTransformer sauceTransformer;
	
	public List<AuthorModel> applyList(List<Author> entities){
		if(ObjectUtils.isEmpty(entities)) {
			return Collections.emptyList();
		}
		return entities.stream().map(this::apply).toList();
	}
	public AuthorModel apply(Author entity) {
		AuthorModel model = new AuthorModel();
		List<SauceModel> sauce = entity.getSauces().stream().map(sauceTransformer::apply).toList();
		model.setId(entity.getId());
		model.setName(entity.getName());
		model.setSauces(sauce);
		return model;
	}
}
