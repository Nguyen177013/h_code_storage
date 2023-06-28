package com.example.storage.ecchi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.storage.ecchi.model.AuthorModel;
import com.example.storage.ecchi.repository.AuthorRepository;
import com.example.storage.ecchi.service.AuthorService;
import com.example.storage.ecchi.transformation.AuthorTransformer;

@Service
public class AuthorServiceImp implements AuthorService{

	@Autowired
	AuthorRepository repository;
	
	@Autowired
	AuthorTransformer transformer;
	
	@Override
	public List<AuthorModel> listAuthors() {
		return transformer.applyList(repository.findAll());
	}
	@Override
	public void addAuthors(AuthorModel author) {
//		repository.save(tranformer.authorModelToEntity(author));
	}
	@Override
	public void removeAuthor(AuthorModel model) {
		
	}
	@Override
	public void editAuthor(AuthorModel author) {
		
	}
	
}
