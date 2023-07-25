package com.example.storage.ecchi.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.storage.ecchi.entity.Sauce;

@Repository
public interface SauceRepository extends JpaRepository<Sauce, Integer> {
	
	@Query("SELECT sauce from Sauce sauce")
	Page<Sauce> getAllSauce(Pageable page);

	@Query("SELECT s FROM SauceType st JOIN st.sauce s WHERE st.type.id = 9")
	List<Sauce> getSauceImage();
}
