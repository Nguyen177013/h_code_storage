package com.example.storage.ecchi.transformation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.example.storage.ecchi.entity.Sauce;
import com.example.storage.ecchi.model.SauceModel;
import com.example.storage.ecchi.repository.AuthorRepository;
import com.example.storage.ecchi.repository.TypeRepository;

@Component
public class SauceTransformer {

	AuthorRepository authorRepository;

	TypeRepository typeRepository;

	public Sauce apply(SauceModel sauceModel) {
		Sauce sauce = new Sauce();
		BeanUtils.copyProperties(sauceModel, sauce);
		return sauce;
	}

	public List<Sauce> applyList(List<SauceModel> sauceModels) {
		if (Objects.isNull(sauceModels)) {
			return Collections.emptyList();
		}
		return sauceModels.stream().map(this::apply).collect(Collectors.toList());
	}

	public List<SauceModel> sauceEntitysToModel(List<Sauce> sauces) {
		List<SauceModel> sauceModels = new ArrayList<>();
		for (Sauce sauce : sauces) {
			SauceModel sauceModel = new SauceModel();
			sauceModel.setName(sauce.getName());
			sauceModel.setType(sauce.getType());
			sauceModel.setAuthor(sauce.getAuthor());
			sauceModels.add(sauceModel);
		}
		return sauceModels;
	}

	
	
	public SauceModel sauceEntityToModel(Sauce sauce) {
		SauceModel sauceModel = new SauceModel();
		sauceModel.setAuthor(sauce.getAuthor());
		sauceModel.setType(sauce.getType());
		sauceModel.setName(sauce.getName());
		return sauceModel;
	}
}
