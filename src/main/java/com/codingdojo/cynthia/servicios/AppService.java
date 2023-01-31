package com.codingdojo.cynthia.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.codingdojo.cynthia.modelos.User;
import com.codingdojo.cynthia.repositorios.RepositorioRoles;
import com.codingdojo.cynthia.repositorios.RepositorioUsuarios;

@Service
public class AppService {
	
	@Autowired
	private RepositorioUsuarios repo_usuarios;
	
	@Autowired
	private RepositorioRoles repo_roles;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//Guardar un usuario tipo ROLE_USER
	public void saveWithUserRole(User user) {
		//user.getPassword ->Me obtiene la contraseña sin encriptar
		//bCryptPasswordEncoder.encode() ->Encripta esa contraseña
		//setPassword() ->Establece contraseña encriptada como password
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		user.setRoles(repo_roles.findByName("ROLE_USER"));
		repo_usuarios.save(user);
	}
	
	//Guardar un usuario tipo ROLE_ADMIN
	public void saveWithAdminRole(User user) {
		//user.getPassword ->Me obtiene la contraseña sin encriptar
		//bCryptPasswordEncoder.encode() ->Encripta esa contraseña
		//setPassword() ->Establece contraseña encriptada como password
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		user.setRoles(repo_roles.findByName("ROLE_ADMIN"));
		repo_usuarios.save(user);
	}
	
	//Regresa usuario en base a su username
	public User findByUsername(String username) {
		return repo_usuarios.findByUsername(username);
	}
	
}
