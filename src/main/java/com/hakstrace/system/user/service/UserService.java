package com.hakstrace.system.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hakstrace.common.code.util.CommonCode;
import com.hakstrace.system.user.domain.Authority;
import com.hakstrace.system.user.domain.User;
import com.hakstrace.system.user.domain.UserSpecification;
import com.hakstrace.system.user.repository.UserRepository;

@Service 
public class UserService{

  @Autowired 
  private UserRepository userRepository;
  @Autowired
  private AuthorityService authorityService;

  @Transactional(readOnly = true)
  public Page<User> findAll(int pageNum, String userName){
	  PageRequest request = new PageRequest(pageNum-1, 10, Sort.Direction.ASC, "userId");
	  Page<User> users = userRepository.findAll(UserSpecification.searchUser(userName), request);
	  return users;
  }
  
  @Transactional(readOnly = true)
  public User findByUserId(String userId){
	  return userRepository.findByUserId(userId);
  }
  
  @Transactional
  public void updateUserDetail(User user){
	  User oUser = userRepository.findByUserId(user.getUserId());
	  oUser.setUserName(user.getUserName());
	  oUser.setEmail(user.getEmail());
	  oUser.setAuthority(user.getAuthority());
	  userRepository.save(oUser);
  }
  
  @Transactional
  public void addUser(User user){
	  user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
	  userRepository.save(user);
  }
  
  @Transactional
  public void registerUser(User user){
	  Authority authority = new Authority();
	  authority.setAuthCode(CommonCode.AUTH_CODE.USER);
	  user.setAuthority(authority);
	  addUser(user);
  }
  
  @Transactional
  public void updateUserPassword(User user){
	  User oUser = userRepository.findByUserId(user.getUserId());
	  oUser.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
	  userRepository.save(oUser);
  }
  
}
