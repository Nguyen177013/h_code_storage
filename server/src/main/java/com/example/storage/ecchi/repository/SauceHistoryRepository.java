package com.example.storage.ecchi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.storage.ecchi.entity.SauceHistory;

@Repository
public interface SauceHistoryRepository extends JpaRepository<SauceHistory, Integer> {

}
