package com.example.storage.ecchi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.storage.ecchi.model.AuthorModel;
import com.example.storage.ecchi.service.AuthorService;

@RestController
@RequestMapping("api/author")
public class AuthorController {
	
	@Autowired
	AuthorService authorService;
	
	@GetMapping("/")
	public ResponseEntity<String> getGreeting() {
		return ResponseEntity.ok("hello author");
	}
	@GetMapping("get-all")
	public ResponseEntity<List<AuthorModel>> getAuthors() {
		return ResponseEntity.ok(authorService.listAuthors());
	}
}
