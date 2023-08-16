package com.example.storage.ecchi.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.storage.ecchi.entity.Sauce;
import com.example.storage.ecchi.entity.SauceHistory;
import com.example.storage.ecchi.model.DateModel;
import com.example.storage.ecchi.model.TotalSauceHistory;
import com.example.storage.ecchi.model.TotalUpload;

@DataJpaTest
@ActiveProfiles("data")
public class SauceHistoryRepositoryTest {
	
	@Autowired
	SauceHistoryRepository sauceHistoryRepository;
	
	@Autowired
	SauceRepository sauceRepository;
	
	@BeforeEach
	void setUp() {

		Sauce sauce = new Sauce();
		sauce.setName("metamorphosis");
		sauceRepository.save(sauce);
		
		Sauce sauce2 = new Sauce();
		sauce2.setName("emergency");
		sauceRepository.save(sauce2);
		
		SauceHistory history = new SauceHistory();
		history.setDateUpload(new Date());
		history.setSauce(sauce);
		
		SauceHistory history2 = new SauceHistory();
		history2.setDateUpload(new Date());
		history2.setSauce(sauce2);
		
		sauceHistoryRepository.save(history);
		sauceHistoryRepository.save(history2);
	}
	
	@Test
	void testGetYear(){
		List<DateModel> years = sauceHistoryRepository.getCurrentYear();
		LocalDate date = LocalDate.now();
		Integer firstYearItem = Integer.parseInt(years.get(0).getCurrentYear());
		assertEquals(firstYearItem, date.getYear());
	}
	
	@Test
	void testGetTotalUpload() {
		TotalUpload totalUpload = sauceHistoryRepository.getTotalUpload();
		assertEquals(2, totalUpload.getTotalUpload());
	}
	
	@Test
	void testCountSauceHistory() {
		List<TotalSauceHistory>	 total = sauceHistoryRepository.countSauceHistory(null, null);
		assertEquals(2, total.get(0).getTotal());
	}
}
