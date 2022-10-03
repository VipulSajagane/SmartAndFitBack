package com.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.main.dao.OwnerDao;
import com.main.dao.TraineeDao;
import com.main.dao.TrainerDao;
import com.main.entity.Login;

@Service
@Component
public class LoginService {
	
	@Autowired
	private OwnerService ownerService;
	@Autowired
	private TrainerService trainerService;
	@Autowired
	private TraineeService traineeService;
	
	public Login isValidUser(String username,String password)
	{
		Login login=new Login();
		login.setStatus("invalid");
		login.setRole("notExist");
		login.setUserid(0);
		
		if(ownerService.isValidUser(username, username))
		{
			System.out.println("in owner service");
			login.setStatus("valid");
			login.setRole("owner");
			login.setUserid(0);
		}
		else if(trainerService.isValidUser(username, username))
		{
			System.out.println("in trainer service");
			login.setStatus("valid");
			login.setRole("trainer");
			login.setUserid(0);
		}
		else if(traineeService.isValidUser(username, username))
		{
			System.out.println("in trainee service");
			login.setStatus("valid");
			login.setRole("trainee");
			login.setUserid(0);
		}
		
		return login;
	}
	
	
	

}
