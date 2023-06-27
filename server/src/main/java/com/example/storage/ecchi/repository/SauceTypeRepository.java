package com.example.storage.ecchi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.storage.ecchi.entity.SauceType;

@Repository
public interface SauceTypeRepository extends JpaRepository<SauceType, Integer> {

}
