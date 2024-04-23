package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	@Query("select u from User u where u.email=?1")
	Optional<User> ifEmailAlreadyExists(String email);
	@Query("select u from User u where userId=(select max(userId) from User u where u.applyType=?1)")
	Optional<User> getLastUserId(String applytype);
	

}
