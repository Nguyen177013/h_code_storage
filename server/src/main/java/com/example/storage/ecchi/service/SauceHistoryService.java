package com.example.storage.ecchi.service;

import java.util.List;

import com.example.storage.ecchi.model.DateModel;
import com.example.storage.ecchi.model.SauceHistoryModel;
import com.example.storage.ecchi.model.TotalSauceHistory;
import com.example.storage.ecchi.model.TotalUpload;

public interface SauceHistoryService {
	List<SauceHistoryModel> getAllSauceHistory();
	
	List<TotalSauceHistory> getSauceHistory(String year, String extract);
	
	List<DateModel> getYear();
	
	TotalUpload getTotalUpload();
}
