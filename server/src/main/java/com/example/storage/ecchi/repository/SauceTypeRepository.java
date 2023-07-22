package com.example.storage.ecchi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.storage.ecchi.entity.SauceType;
import com.example.storage.ecchi.entity.Type;

@Repository
public interface SauceTypeRepository extends JpaRepository<SauceType, Integer> {
	@Query("SELECT type FROM Type type WHERE type.id = 9")
	Type getImageType();
}
