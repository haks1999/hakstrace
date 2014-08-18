package com.hakstrace.system.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hakstrace.system.user.domain.Authority;
import com.hakstrace.system.user.repository.AuthorityRepository;

@Service 
public class AuthorityService{

  @Autowired 
  private AuthorityRepository authorityRepository;

  @Transactional(readOnly = true)
  public List<Authority> findAll(){
	  return authorityRepository.findAll();
  }
  
  
}
