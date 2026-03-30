package com.common.share.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.common.share.dto.User;

@Repository
public interface RegistationRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByUserName(String userName);

}
