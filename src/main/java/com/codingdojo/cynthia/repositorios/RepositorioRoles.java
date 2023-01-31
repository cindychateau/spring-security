package com.codingdojo.cynthia.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.cynthia.modelos.Role;

@Repository
public interface RepositorioRoles extends CrudRepository<Role, Long> {
	
	List<Role> findAll();
	
	List<Role> findByName(String name);
	
}
