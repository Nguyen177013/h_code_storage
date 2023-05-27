package com.example.storage.ecchi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.storage.ecchi.entity.Type;
import com.example.storage.ecchi.model.TypeModel;

@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {
	@Query(value = "SELECT * FROM type", nativeQuery = true)
	List<Type> getTypes();
}
