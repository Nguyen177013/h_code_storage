package com.example.storage.ecchi.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.storage.ecchi.model.TypeModel;
import com.example.storage.ecchi.repository.TypeRepository;
import com.example.storage.ecchi.service.TypeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RunWith(MockitoJUnitRunner.class)
public class TypeControllerTest {
	private MockMvc mockMvc;

	ObjectMapper objectMapper = new ObjectMapper();
	ObjectWriter objectWriter = objectMapper.writer();

	@Mock
	private TypeRepository typeRepository;

	@InjectMocks
	private TypeController typeController;

	@Mock
	private TypeService service;
	TypeModel type_1 = new TypeModel("Echhi");
	TypeModel type_2 = new TypeModel("Image");
	TypeModel type_3 = new TypeModel("Video");

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(typeController).build();
	}

	@Test
	public void getAllType() throws Exception {
		List<TypeModel> types = new ArrayList<>(Arrays.asList(type_1, type_2, type_3));
		Mockito.when(service.listTypes()).thenReturn(types);
		mockMvc.perform(MockMvcRequestBuilders.get("/api/type/list-types").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", is("Image")));
	}
}
