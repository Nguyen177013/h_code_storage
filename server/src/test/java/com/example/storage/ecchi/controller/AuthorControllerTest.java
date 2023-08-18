package com.example.storage.ecchi.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import com.example.storage.ecchi.model.AuthorModel;
import com.example.storage.ecchi.service.AuthorService;

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class AuthorControllerTest {

	@InjectMocks
	AuthorController authorController;

	@MockBean
	AuthorService authorService;

	@Test
	void testGetAuthors() {
		List<AuthorModel> authors = new ArrayList<>();
		AuthorModel test1 = new AuthorModel();
		test1.setName("Kinz");

		authors.add(test1);
		Mockito.when(authorService.listAuthors()).thenReturn(authors);
		ResponseEntity<List<AuthorModel>> response = authorController.getAuthors();
		assertEquals(200, response.getStatusCodeValue());
		assertEquals("Kinz", response.getBody().get(0).getName());
	}
}
