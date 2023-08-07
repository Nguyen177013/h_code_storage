package com.example.storage.ecchi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.storage.ecchi.model.SauceModel;
import com.example.storage.ecchi.service.SauceService;

@RestController
@RequestMapping("api/sauce")
public class SauceController {

	@Autowired
	SauceService sauceService;

	@GetMapping("/get-all")
	public Page<SauceModel> getSauces(@RequestParam(defaultValue = "0") Integer page, String sauceTypeId, Integer month,
			Integer year) {
		return sauceService.getSauce(page, sauceTypeId, month, year);
	}

	@GetMapping("/{id}")
	public SauceModel getSaucesById(@PathVariable("id") int id) {
		return sauceService.getSauceById(id);
	}

	@PostMapping("/add")
	public void getSaucesById(@RequestBody SauceModel sauce) {
		sauceService.addSauce(sauce);
	}

	@PostMapping("/edit/{id}")
	public void editSaucesById(@PathVariable("id") int id, @RequestBody SauceModel sauce) {
		sauceService.editSauce(id, sauce);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteSaucesById(@PathVariable("id") int id) {
		if (sauceService.deleteSauce(id)) {
			return "Sauce has been deleted";
		}
		return "something wrong with the server";
	}

	@PostMapping("/upload")
	public List<SauceModel> handleFileUpload(@RequestParam("files") MultipartFile[] files) {
		return sauceService.uploadImage(files);
	}

}
