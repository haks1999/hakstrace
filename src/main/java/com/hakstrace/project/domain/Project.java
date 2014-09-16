package com.hakstrace.project.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hakstrace.framework.domain.Domain;

@Entity
@Table(name="projects")
public class Project extends Domain{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="project_key", nullable = false)
	private String projectKey;

	@Column(name="project_name", nullable = false)
	private String projectName;
	
	@Column(name="project_alias", nullable = false)
	private String projectAlias;
	
	@Column(name="description", nullable = false)
	private String description;

	public String getProjectKey() {
		return projectKey;
	}

	public void setProjectKey(String projectKey) {
		this.projectKey = projectKey;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectAlias() {
		return projectAlias;
	}

	public void setProjectAlias(String projectAlias) {
		this.projectAlias = projectAlias;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

	
}
