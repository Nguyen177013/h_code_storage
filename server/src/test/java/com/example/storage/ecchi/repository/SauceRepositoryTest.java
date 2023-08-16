package com.example.storage.ecchi.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;

import com.example.storage.ecchi.entity.Sauce;
import com.example.storage.ecchi.entity.SauceHistory;
import com.example.storage.ecchi.entity.SauceType;
import com.example.storage.ecchi.entity.Type;

@DataJpaTest
@ActiveProfiles("data")
public class SauceRepositoryTest {
	@Autowired
	SauceRepository sauceRepository;
	
	@Autowired
	SauceHistoryRepository sauceHistoryRepository;
	
	@Autowired
	SauceTypeRepository sauceTypeRepository;

	@Autowired
	TypeRepository typeRepository;
	@BeforeEach
	void setUp() {

		Type type = new Type();
		type.setName("Image");
		typeRepository.save(type);

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
		
		SauceType sauceType = new SauceType();
		sauceType.setSauce(sauce);
		sauceType.setType(type);

		SauceType sauceType2 = new SauceType();
		sauceType2.setSauce(sauce2);
		sauceType2.setType(type);
		
		sauceTypeRepository.save(sauceType);
		sauceTypeRepository.save(sauceType2);
	}

	@Test
	void testGetAllSauce() {
		Pageable pageable = PageRequest.of(0, 12);
		Page<Sauce> getAllSauce = sauceRepository.getAllSauce(pageable, null, null, null);
		System.out.println(getAllSauce.getContent().size());
		assertEquals("metamorphosis", getAllSauce.getContent().get(1).getName());
		assertEquals(2, getAllSauce.getContent().size());
	}
}
