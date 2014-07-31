package com.hakstrace.framework.security.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import com.hakstrace.framework.security.domain.User;

public interface UserRepository extends Repository<User, String> {

	Page<User> findAll(Pageable pageable);

	/*
	Page<User> findByNameContainingAndCountryContainingAllIgnoringCase(String name,
			String country, Pageable pageable);
	
	City findByNameAndCountryAllIgnoringCase(String name, String country);
	*/
	
	User findById(String id);

}
