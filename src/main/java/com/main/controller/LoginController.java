package com.main.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.main.entity.Login;
import com.main.entity.Owner;
import com.main.service.LoginService;

@RestController
@CrossOrigin(origins ="http://localhost:3000/")
public class LoginController {
	
	@Autowired
	LoginService loginService;

	@GetMapping("/getLogin/{username}/{password}")
	public Login getdata(@PathVariable("username")  String username,@PathVariable("password")  String password)
	{
		System.out.println(username+"-----"+password);
		return loginService.isValidUser(username, password);
	}
}
	

