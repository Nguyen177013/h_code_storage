package com.example.storage.ecchi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.storage.ecchi.model.SauceTypeModel;
import com.example.storage.ecchi.service.SauceTypeService;

@RestController
@RequestMapping("/api/sauce-type")
public class SauceTypeController {

	@Autowired
	SauceTypeService sauceTypeService;
	
	@GetMapping("/get-all")
	List<SauceTypeModel> getAllSauceType(){
		return sauceTypeService.getAllSauceType();
	}
}
