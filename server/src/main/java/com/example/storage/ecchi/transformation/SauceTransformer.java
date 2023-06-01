package com.example.storage.ecchi.transformation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.storage.ecchi.entity.Author;
import com.example.storage.ecchi.entity.Sauce;
import com.example.storage.ecchi.model.AuthorModel;
import com.example.storage.ecchi.model.SauceModel;
import com.example.storage.ecchi.repository.AuthorRepository;
import com.example.storage.ecchi.repository.TypeRepository;

@Component
public class SauceTransformer {
	
	AuthorRepository authorRepository;
	
	TypeRepository typeRepository;
	
	public List<SauceModel> authorEntitysToModel(List<Sauce> sauces) {
		List<SauceModel> authorModels = new ArrayList<>();
		for (Sauce sauce : sauces) {
			SauceModel sauceModel = new SauceModel();
			sauceModel.setName(sauce.getName());
//			sauceModel.setIdType(typeRepository.findById(sauce.getId()));
//			authorModels.add(authorModel);
		}
		return authorModels;
	}

	public List<Author> authorModelsToEntity(List<AuthorModel> authorModels) {
		List<Author> authors = new ArrayList<>();
		for (AuthorModel model : authorModels) {
			Author author = new Author();
			author.setName(model.getName());
			authors.add(author);
		}
		return authors;
	}

	public Author authorModelToEntity(AuthorModel authorModels) {
		Author author = new Author();
		author.setName(authorModels.getName());
		return author;
	}
}
