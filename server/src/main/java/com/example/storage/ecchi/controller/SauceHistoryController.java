package com.example.storage.ecchi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.storage.ecchi.model.DateModel;
import com.example.storage.ecchi.model.SauceHistoryModel;
import com.example.storage.ecchi.model.TotalSauceHistory;
import com.example.storage.ecchi.service.SauceHistoryService;

@RestController
@RequestMapping("/api/sauce-history")
public class SauceHistoryController {

	@Autowired
	SauceHistoryService sauceHistoryService;

	@GetMapping("/get-all")
	List<SauceHistoryModel> getAllSauceHistory() {
		return sauceHistoryService.getAllSauceHistory();
	}

	@GetMapping("/get-history")
	List<TotalSauceHistory> getSauceHistory(@RequestParam(defaultValue = "", value = "year") String year,
			@RequestParam(defaultValue = "year", value = "dateUpload") String dateUpload) {
		return sauceHistoryService.getSauceHistory(year, dateUpload);
	}

	@GetMapping("/get-year")
	List<DateModel> getYear() {
		return sauceHistoryService.getYear();
	}

	@GetMapping("get-month/{year}")
	List<DateModel> getMonth(@PathVariable("year") String year) {
		return sauceHistoryService.getMonth(year);
	}
}
