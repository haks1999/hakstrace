package com.hakstrace.system.user.domain;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {

	public static Specification<User> searchUser(final String userName) {
        return new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
            	//Root<User> users = query.from(User.class);
            	//Predicate customerIsAccountOwner = cb.equal(users.<User> get("customer"), root);
            	
            	//Predicate accountExpiryDateBefore = cb.lessThan(expiryDate, date.toDateTimeAtStartOfDay().toDate());
            	//return cb.and(customerIsAccountOwner, accountExpiryDateBefore);
                //return cb.like(root.get(User_.userName), "%" + keyword + "%");
            	
            	Predicate userNameLike = cb.like(root.<String> get("userName"), "%"+userName+"%");
            	return userNameLike;
            }
        };
    }
}
