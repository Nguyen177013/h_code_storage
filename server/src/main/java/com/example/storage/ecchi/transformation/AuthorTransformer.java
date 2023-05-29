package com.example.storage.ecchi.transformation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.storage.ecchi.entity.Author;
import com.example.storage.ecchi.model.AuthorModel;

@Component
public class AuthorTransformer {
	public List<AuthorModel> authorEntitysToModel(List<Author> authors) {
		List<AuthorModel> authorModels = new ArrayList<>();
		for (Author author : authors) {
			AuthorModel authorModel = new AuthorModel();
			authorModel.setName(author.getName());
			authorModels.add(authorModel);
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
