package com.hakstrace.system.user.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.hakstrace.system.user.domain.Authority;

public interface AuthorityRepository extends Repository<Authority, String> {

	List<Authority> findAll();

	Authority findByAuthCode(String authCode);
}
