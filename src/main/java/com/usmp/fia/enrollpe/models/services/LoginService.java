package com.usmp.fia.enrollpe.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usmp.fia.enrollpe.models.entitys.Login;


@Service
public class LoginService {

	@Autowired
	private LoginRepository repo;
	  
	  public Login login(String username, String password) {
	  Login user = repo.findByUsernameAndPassword(username, password);
	   return user;
	  }
	 
}
