
package com.example.storage.ecchi.transformation;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.example.storage.ecchi.entity.Sauce;
import com.example.storage.ecchi.entity.SauceHistory;
import com.example.storage.ecchi.entity.SauceType;
import com.example.storage.ecchi.model.SauceModel;
import com.example.storage.ecchi.model.SauceTypeModel;
import com.example.storage.ecchi.repository.AuthorRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SauceTransformer {

	private final SauceTypeTransformer sauceTypeTransformer;

	private final AuthorRepository authorRepository;

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
		if (!(entity.getAuthor() == null)) {
			model.setAuthorId(entity.getAuthor().getId());
			model.setAuthorName(entity.getAuthor().getName());
		}
		model.setSauceImage(entity.getSauceImage());
		model.setSauceUrl(entity.getSauceUrl());
		model.setSauceType(sauceTypes);
		return model;
	}

	public Sauce applySauceModel(SauceModel model, List<SauceHistory> historys, List<SauceType> types) {
		Sauce sauce = new Sauce();
		if (model.getAuthorId() != null) {
			sauce.setAuthor(authorRepository.findById(model.getAuthorId()).get());
		}
		sauce.setName(model.getName());
		sauce.setSauceHistory(historys);
		sauce.setSauceImage(model.getSauceImage());
		sauce.setSauceUrl(model.getSauceUrl());
		sauce.setSauceType(types);
		return sauce;
	}
}
