package com.example.storage.ecchi.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.storage.ecchi.entity.Sauce;
import com.example.storage.ecchi.entity.SauceType;
import com.example.storage.ecchi.entity.Type;

@DataJpaTest
@ActiveProfiles("data")
public class SauceTypeRepositoryTest {

	@Autowired
	SauceRepository sauceRepository;
	
	@Autowired
	SauceTypeRepository sauceTypeRepository;

	@Autowired
	TypeRepository typeRepository;
	
	@BeforeEach
	void setUp() {
		
		Type type = new Type();
		type.setName("Image");
		typeRepository.save(type);
		
		Type type2 = new Type();
		type2.setName("NTR");
		typeRepository.save(type2);
		
	}
	
	@Test
	void testGetImageType() {
		Type type = sauceTypeRepository.getImageType();
		assertEquals("Image", type.getName());
	}
}
