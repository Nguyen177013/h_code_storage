package com.example.storage.ecchi.service;

import java.util.List;

import com.example.storage.ecchi.model.AuthorModel;

public interface AuthorService {
	List<AuthorModel> listAuthors();
	void addAuthors(AuthorModel author);
	void removeAuthor(AuthorModel author);
	void editAuthor(AuthorModel author);
}
