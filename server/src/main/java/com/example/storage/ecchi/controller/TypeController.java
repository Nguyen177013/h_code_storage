package com.example.storage.ecchi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.storage.ecchi.model.TypeModel;
import com.example.storage.ecchi.service.TypeService;

@RestController
@RequestMapping("/api/type")
public class TypeController {
	
	@Autowired
	TypeService typeService;
	
	@GetMapping("")
	public String gretting() {
		System.out.println("hello");
		return "Hello world";
	}
	@GetMapping("/list-types")
	public ResponseEntity<List<TypeModel>> getTyes() {
		return ResponseEntity.ok(typeService.listTypes());
	}
}
