package com.hakstrace.framework.security.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hakstrace.framework.security.domain.User;
import com.hakstrace.framework.security.repository.UserRepository;

@Service 
public class MyUserDetailsService implements UserDetailsService {

  @Autowired 
  private UserRepository userRepository;

  @Transactional(readOnly = true)
  public UserDetails loadUserByUsername(String userName)
      throws UsernameNotFoundException, DataAccessException {

    UserDetails userDetails = null;
System.out.println("userRepo : " + userRepository);    
    User user = userRepository.findById(userName);
System.out.println("###############");    
System.out.println(user);    
System.out.println("###############");
    if (user == null)
      throw new UsernameNotFoundException("user not found");

    String username = user.getUserName();
    String password = user.getPassword();
    boolean enabled = true; //userEntity.isActive();
    boolean accountNonExpired = true; //userEntity.isActive();
    boolean credentialsNonExpired = true; //userEntity.isActive();
    boolean accountNonLocked = true; //userEntity.isActive();w

    Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    /*
    for (SecurityRoleEntity role : userEntity.getRoles()) {
      authorities.add(new GrantedAuthorityImpl(role.getRoleName()));
    }
    */

    return new org.springframework.security.core.userdetails.User(username, password, enabled,
      accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    
  }
}
