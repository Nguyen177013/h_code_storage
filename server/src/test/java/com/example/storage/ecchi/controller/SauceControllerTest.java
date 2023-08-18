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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.multipart.MultipartFile;

import com.example.storage.ecchi.model.SauceModel;
import com.example.storage.ecchi.service.SauceService;

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)

public class SauceControllerTest {

	@InjectMocks
	SauceController sauceController;

	@MockBean
	SauceService sauceService;

	private List<SauceModel> sauces = new ArrayList<>();

	@BeforeEach

	void setUp() {
		SauceModel test1 = new SauceModel();
		test1.setName("H");
		SauceModel test2 = new SauceModel();
		test2.setName("E");
		SauceModel test3 = new SauceModel();
		test3.setName("N");
		SauceModel test4 = new SauceModel();
		test4.setName("T");
		sauces = List.of(test1, test2, test3, test4);
	}

	@Test
	void testGetSauces() {
		Page<SauceModel> listSauce = new PageImpl<>(sauces);
		Mockito.when(sauceService.getSauce(0, null, null, null)).thenReturn(listSauce);
		Page<SauceModel> result = sauceController.getSauces(0, null, null, null);
		assertEquals(4, result.getSize());
		assertEquals("H", result.getContent().get(0).getName());
	}

	@Test
	void testGetSaucesById() {
		Mockito.when(sauceService.getSauceById(2)).thenReturn(sauces.get(2));
		SauceModel result = sauceController.getSaucesById(2);
		assertEquals("N", result.getName());
	}

	@Test
	void testAddSauces() {
		sauceController.addSauces(sauces.get(1));
	}

	@Test
	void testEditSaucesById() {
		sauceController.editSaucesById(2, sauces.get(1));
	}

	@Test
	void testDeleteSaucesById_whenRightId_returnSuccessMessage() {
		Mockito.when(sauceService.deleteSauce(2)).thenReturn(true);
		String result = sauceController.deleteSaucesById(2);
		assertEquals("Sauce has been deleted", result);
	}

	@Test
	void testDeleteSaucesById_whenWrongId_returnErrorMessage() {
		Mockito.when(sauceService.deleteSauce(2)).thenReturn(false);
		String result = sauceController.deleteSaucesById(2);
		assertEquals("Something wrong with the server", result);
	}

	@Test
	void testHandleFileUpload() {
		MultipartFile[] files = { new MockMultipartFile("files", "image.png", "img/png", "Image Name".getBytes()) };
		Mockito.when(sauceService.uploadImage(files)).thenReturn(sauces);
		List<SauceModel> result = sauceController.handleFileUpload(files);
		assertEquals(4, result.size());
	}
}
