package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.PassportRenewal;
import com.example.demo.model.User;

@Repository
public interface HomeRepository extends JpaRepository<PassportRenewal, String>{
	
	@Query("select p from PassportRenewal p ")
	Optional<List<PassportRenewal>> getLastPassportId(String applytype);
	
	@Query("select p from PassportRenewal p where p.userid=?1")
	Optional<PassportRenewal> getOldPassport(String userid);
	
	
	

}
