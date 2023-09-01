package com.example.storage.ecchi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.storage.ecchi.entity.Sauce;

@Repository
public interface SauceRepository extends JpaRepository<Sauce, Integer> {

	@Query(nativeQuery = true, value = "SELECT s.* " + "FROM sauce s " + "JOIN history h ON s.id = h.sauce_id "
			+ "JOIN sauce_type ON sauce_type.sauce_id = s.id " 
			+ "JOIN account_sauce ON account_sauce.sauce_id = s.id " 
			+ "WHERE " + "((:year IS NULL AND :month IS NULL) OR "
			+ "(EXTRACT(YEAR FROM h.date_upload) = COALESCE(:year, EXTRACT(YEAR FROM CURRENT_DATE)) "
			+ "AND EXTRACT(MONTH FROM h.date_upload) = COALESCE(:month, EXTRACT(MONTH FROM CURRENT_DATE)) "
			+ "AND ((:sauceTypeId IS NULL) or sauce_type.type_id = CAST(:sauceTypeId AS INTEGER)))) "
			+ "AND account_sauce.account_id = CAST(:userId AS INTEGER) "
			+ "ORDER BY s.id DESC")
	Page<Sauce> getAllSauce(Pageable page, String sauceTypeId, Integer month, Integer year, Integer userId);
}
