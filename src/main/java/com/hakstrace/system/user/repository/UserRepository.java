package com.hakstrace.system.user.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.Repository;

import com.hakstrace.system.user.domain.User;

public interface UserRepository extends Repository<User, String> {

	Page<User> findAll(Specification<User> spec, Pageable pageable);

	/*
	Page<User> findByNameContainingAndCountryContainingAllIgnoringCase(String name,
			String country, Pageable pageable);
	
	City findByNameAndCountryAllIgnoringCase(String name, String country);
	*/
	
	User findByUserId(String userId);
	
	void save(User user);

}
