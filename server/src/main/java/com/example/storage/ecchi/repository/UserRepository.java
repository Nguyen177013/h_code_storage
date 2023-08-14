package com.example.storage.ecchi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.storage.ecchi.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	@Query("SELECT user FROM User user WHERE user.userEmail = :email")
	User findByEmail(String email);
}
