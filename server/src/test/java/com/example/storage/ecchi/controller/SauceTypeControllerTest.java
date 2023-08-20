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

import com.example.storage.ecchi.model.SauceTypeModel;
import com.example.storage.ecchi.service.SauceTypeService;

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)

public class SauceTypeControllerTest {

	@InjectMocks
	SauceTypeController sauceTypeController;

	@MockBean
	SauceTypeService sauceTypeService;

	List<SauceTypeModel> sauceTypes = new ArrayList<>();
	@BeforeEach
	void setUp() {
		SauceTypeModel test1 = new SauceTypeModel();
		SauceTypeModel test2 = new SauceTypeModel();
		SauceTypeModel test3 = new SauceTypeModel();
		SauceTypeModel test4 = new SauceTypeModel();
		sauceTypes = List.of(test1, test2, test3, test4);
	}

	@Test
	void testGetAllSauceType() {
		Mockito.when(sauceTypeService.getAllSauceType()).thenReturn(sauceTypes);
		List<SauceTypeModel> result = sauceTypeController.getAllSauceType();
		assertEquals(4, result.size());
	}
}
