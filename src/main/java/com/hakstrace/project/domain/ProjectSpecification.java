package com.hakstrace.project.domain;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

public class ProjectSpecification {

	public static Specification<Project> searchProject(final String projectName) {
        return new Specification<Project>() {
            @Override
            public Predicate toPredicate(Root<Project> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
            	Predicate projectNameLike = cb.like(root.<String> get("projectName"), "%"+projectName+"%");
            	return projectNameLike;
            }
        };
    }
}
