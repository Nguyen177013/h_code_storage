package com.example.storage.ecchi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<SauceModel> getSauces(@RequestParam(defaultValue = "0", value = "page") Integer page) {
		return sauceService.getSauce(page);
	}
	
	@GetMapping("/sauces/{id}")
	public SauceModel getSaucesById(@PathVariable("id") int id) {
		return sauceService.getSauceById(id);
	}
	
	@PostMapping("/sauces/add")
	public void getSaucesById(@RequestBody SauceModel sauce) {
		sauceService.addSauce(sauce);
	}
	
	@PostMapping("/sauces/edit/{id}")
	public void editSaucesById(@PathVariable("id") int id, @RequestBody SauceModel sauce) {
		sauceService.editSauce(id, sauce);
	}
	
	@DeleteMapping("/sauces/delete/{id}")
	public void deleteSaucesById(@PathVariable("id") int id) {
		sauceService.deleteSauce(id);
	}
	
	@GetMapping("/upload")
    public String handleFileUpload() {
//		System.out.println(file);
        return "File uploaded successfully";
    }

}
