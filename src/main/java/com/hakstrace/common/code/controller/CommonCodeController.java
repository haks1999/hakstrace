package com.hakstrace.common.code.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hakstrace.common.code.domain.CommonCode;
import com.hakstrace.common.service.CommonCodeService;

@Controller
public class CommonCodeController {
	
	@Autowired
	private CommonCodeService commonCodeService;

	@RequestMapping(value="/common/codes/authority", method = RequestMethod.GET)
	@ResponseBody
	public List<CommonCode> retrieveAuthorityCodeList() {
		return commonCodeService.findAllAuthority();
	}
	
}
