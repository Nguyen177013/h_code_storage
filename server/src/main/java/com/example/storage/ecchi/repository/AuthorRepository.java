package com.example.storage.ecchi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.storage.ecchi.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
	@Query(value = "SELECT * FROM author", nativeQuery = true)
	List<Author> getAuthor();
}
