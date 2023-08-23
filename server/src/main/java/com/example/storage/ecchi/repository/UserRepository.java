package com.example.storage.ecchi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.storage.ecchi.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query("SELECT account "
			+ "FROM User account "
			+ "WHERE account.userEmail = CAST(:email AS STRING) OR account.userName = CAST(:userName AS STRING)")
	User findUser(String email, String userName);
}
