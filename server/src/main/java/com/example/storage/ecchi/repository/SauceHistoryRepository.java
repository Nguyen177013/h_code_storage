package com.example.storage.ecchi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.storage.ecchi.entity.SauceHistory;
import com.example.storage.ecchi.model.DateModel;
import com.example.storage.ecchi.model.TotalSauceHistory;

@Repository
public interface SauceHistoryRepository extends JpaRepository<SauceHistory, Integer> {
	@Query(nativeQuery = true, value = "SELECT COUNT(h.id) AS total, " + "CASE :dateUpload "
			+ "WHEN 'year' THEN extract('year' from h.date_upload) "
			+ "WHEN 'month' THEN extract('month' from h.date_upload) " 
			+ "WHEN 'day' THEN extract('day' from h.date_upload) "
			+ "END AS dateFormat " + "FROM history h "
			+ "WHERE (:year IS NULL OR :year = '' OR extract(year from h.date_upload) = CAST(:year AS INTEGER)) "
			+ "GROUP BY dateFormat")
	List<TotalSauceHistory> countSauceHistory(@Param("year") String year, @Param("dateUpload") String dateUpload);

	@Query(nativeQuery = true, value = "SELECT CAST(extract('year' from h.date_upload) AS INTEGER) AS year "
			+ "FROM history h "
			+ "GROUP BY extract('year' from h.date_upload)")
	List<DateModel> getYear();
	
	@Query(nativeQuery = true, value = "SELECT CAST(extract('month' from h.date_upload) AS INTEGER) AS month "
			+ "FROM history h "
			+ "WHERE extract('year' from h.date_upload) = CAST(:year as INTEGER) "
			+ "GROUP BY extract('month' from h.date_upload)")
	List<DateModel> getMonth(@Param("year") String year);
}
