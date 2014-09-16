package com.hakstrace.project.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.Repository;

import com.hakstrace.project.domain.Project;

public interface ProjectRepository extends Repository<Project, String> {

	Page<Project> findAll(Specification<Project> spec, Pageable pageable);

}
