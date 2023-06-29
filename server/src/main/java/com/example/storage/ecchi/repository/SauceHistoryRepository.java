package com.example.storage.ecchi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.storage.ecchi.entity.SauceHistory;

@Repository
public interface SauceHistoryRepository extends JpaRepository<SauceHistory, Integer> {
	@Query("SELECT COUNT(h.id), h.dateUpload FROM SauceHistory h GROUP BY h.dateUpload")
	List<Object> countSauceHistory();
}
