package com.hakstrace.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hakstrace.project.domain.Project;
import com.hakstrace.project.service.ProjectService;

@Controller
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;

	@RequestMapping(value="/projects", method = RequestMethod.GET, consumes="!application/json")
	public String forwardToProjectList() {
		return "hakstrace/project/project_list";
	}
	
	@RequestMapping(value="/projects", method = RequestMethod.GET, consumes="application/json")
	@ResponseBody
	public Page<Project> retrieveProjectList( @RequestParam(value = "projectName", required = false, defaultValue="") String projectName,
										@RequestParam(value = "pageNum", required = false, defaultValue="1") int pageNum) {
		return projectService.findAll(pageNum, projectName);
	}
	
	
}
