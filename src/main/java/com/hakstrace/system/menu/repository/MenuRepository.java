package com.hakstrace.system.menu.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.hakstrace.system.menu.domain.Menu;

public interface MenuRepository extends Repository<Menu, String> {

	List<Menu> findAll();

}
