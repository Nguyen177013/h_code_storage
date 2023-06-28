package com.example.storage.ecchi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.storage.ecchi.entity.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {
}
