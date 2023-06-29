package com.example.storage.ecchi.service;

import java.util.List;

import com.example.storage.ecchi.model.SauceHistoryModel;
import com.example.storage.ecchi.model.TotalSauceHistory;

public interface SauceHistoryService {
	List<SauceHistoryModel> getAllSauceHistory();
	
	List<TotalSauceHistory> getSauceHistory(String year, String extract);
}
