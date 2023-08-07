package com.example.storage.ecchi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.storage.ecchi.entity.Sauce;

@Repository
public interface SauceRepository extends JpaRepository<Sauce, Integer> {

	@Query(nativeQuery = true, 
			value = "SELECT s.* "
					+ "FROM sauce s "
					+ "JOIN history h ON s.id = h.sauce_id "
					+ "JOIN sauce_type ON sauce_type.sauce_id = s.id "
					+ "WHERE "
					+ "EXTRACT(YEAR FROM h.date_upload) = EXTRACT(YEAR FROM CURRENT_DATE) "
					+ "AND EXTRACT(MONTH FROM h.date_upload) = EXTRACT(MONTH FROM CURRENT_DATE) "
					+ "AND ((:sauceTypeId is null) or sauce_type.type_id = CAST(:sauceTypeId AS INTEGER))")
	Page<Sauce> getAllSauce(Pageable page, String sauceTypeId);
}
