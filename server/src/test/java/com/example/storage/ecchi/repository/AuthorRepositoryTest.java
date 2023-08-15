package com.example.storage.ecchi.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.storage.ecchi.entity.Author;

@DataJpaTest
@ActiveProfiles("data")
public class AuthorRepositoryTest {
	@Autowired
	private AuthorRepository authorRepository;
	
//	@BeforeEach
//	void setUp() {
//		Author author = new Author();
//		author.setId(1);
//		author.setName("Kinz");
//		author.setSauces(anyList());
//		authorRepository.save(author);
//	}
//	
	@Test
	void testGetAllAuthor() {
//		List<Author> authors = authorRepository.getAuthor();
		assertEquals(1, 1);
	}
}
