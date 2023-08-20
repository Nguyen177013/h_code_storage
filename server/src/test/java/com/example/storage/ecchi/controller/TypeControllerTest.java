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

import com.example.storage.ecchi.model.TypeModel;
import com.example.storage.ecchi.service.TypeService;

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)

public class TypeControllerTest {
	
	@InjectMocks
	TypeController typeController;
	
	@MockBean
	TypeService typeService;
	
	private List<TypeModel> types = new ArrayList<>();
	
	@BeforeEach
	void setUp() {
		TypeModel test1 = new TypeModel();
		test1.setName("NTR");
		TypeModel test2 = new TypeModel();
		test2.setName("Vanila");
		TypeModel test3 = new TypeModel();
		test3.setName("Drama");
		TypeModel test4 = new TypeModel();
		test4.setName("Guro");
		types.add(test1);
		types.add(test2);
		types.add(test3);
		types.add(test4);
	}
	
	@Test
	void testGetAllType() {
		Mockito.when(typeService.listTypes()).thenReturn(types);
		List<TypeModel> result = typeController.getTyes();
		assertEquals(4, result.size());
		assertEquals("Drama", result.get(2).getName());
	}
}
