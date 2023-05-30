package com.example.storage.ecchi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.storage.ecchi.entity.Sauce;

@Repository
public interface SauceRepository extends JpaRepository<Sauce, Integer> {

}
