package com.hakstrace.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hakstrace.project.domain.Project;
import com.hakstrace.project.domain.ProjectSpecification;
import com.hakstrace.project.repository.ProjectRepository;

@Service 
public class ProjectService{

  @Autowired 
  private ProjectRepository projectRepository;

  @Transactional(readOnly = true)
  public Page<Project> findAll(int pageNum, String projectName){
	  PageRequest request = new PageRequest(pageNum-1, 10, Sort.Direction.ASC, "projectName");
	  Page<Project> projects = projectRepository.findAll(ProjectSpecification.searchProject(projectName), request);
	  return projects;
  }
  
  
}
