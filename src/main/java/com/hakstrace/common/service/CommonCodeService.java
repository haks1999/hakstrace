package com.hakstrace.common.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hakstrace.common.code.domain.CommonCode;
import com.hakstrace.system.user.domain.Authority;
import com.hakstrace.system.user.service.AuthorityService;

@Service 
public class CommonCodeService{

  @Autowired 
  private AuthorityService authorityService;

  @Transactional(readOnly = true)
  public List<CommonCode> findAllAuthority(){
	  List<Authority> authorityList = authorityService.findAll();
	  List<CommonCode> commonCodeList = new ArrayList<CommonCode>();
	  for( Authority authority : authorityList ){
		  CommonCode commonCode = new CommonCode();
		  commonCode.setText(authority.getAuthName());
		  commonCode.setValue(authority.getAuthCode());
		  commonCodeList.add(commonCode);
	  }
	  return commonCodeList;
  }
  
  
}
