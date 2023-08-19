package com.example.storage.ecchi.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.example.storage.ecchi.model.SauceHistoryModel;
import com.example.storage.ecchi.service.SauceHistoryService;

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)

public class SauceHistoryControllerTest {

	@InjectMocks
	SauceHistoryController sauceHistoryController;

	@MockBean
	SauceHistoryService sauceHistoryService;

	private List<SauceHistoryModel> sauces = new ArrayList<>();

	@BeforeEach
	void setUp() {
		SauceHistoryModel test1 = new SauceHistoryModel();
		test1.setSauceName("H");
		SauceHistoryModel test2 = new SauceHistoryModel();
		test2.setSauceName("E");
		SauceHistoryModel test3 = new SauceHistoryModel();
		test3.setSauceName("N");
		SauceHistoryModel test4 = new SauceHistoryModel();
		test4.setSauceName("T");

		sauces.add(test1);
		sauces.add(test2);
		sauces.add(test3);
		sauces.add(test4);
	}

	@Test
	void testGetAllSauceHistory() {
		Mockito.when(sauceHistoryService.getAllSauceHistory()).thenReturn(sauces);
		List<SauceHistoryModel> result = sauceHistoryController.getAllSauceHistory();
		assertEquals(4, result.size());
	}
}
