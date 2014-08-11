package com.hakstrace.system.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hakstrace.system.user.domain.User;
import com.hakstrace.system.user.domain.UserSpecification;
import com.hakstrace.system.user.repository.UserRepository;

@Service 
public class UserService{

  @Autowired 
  private UserRepository userRepository;

  @Transactional(readOnly = true)
  public Page<User> findAll(int pageNum, String userName){
	  PageRequest request = new PageRequest(pageNum-1, 30, Sort.Direction.ASC, "id");
	  Page<User> users = userRepository.findAll(UserSpecification.searchUser(userName), request);
	  return users;
  }
}
