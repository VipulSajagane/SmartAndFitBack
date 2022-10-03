package com.main.service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.main.dao.TraineeDao;
import com.main.entity.Trainee;
import com.main.entity.Trainer;

@Service
@Component
public class TraineeService {

	@Autowired
	private TraineeDao dao;
	
	Base64.Encoder encoder = Base64.getEncoder();
	Base64.Decoder decoder = Base64.getDecoder();
	
	public Optional<Trainee> fetchTrainee(int id) {

		Optional<Trainee> t=dao.findById(id);
		
		byte[] actualByte= Base64.getDecoder().decode(t.get().getPassword());
		String actualString= new String(actualByte); 
		t.get().setPassword(actualString);
		
		return t;
		
	}
	public Trainee getTrainer(String username)
	{
		return dao.findTrainee(username);
	}
	
     public List<Trainee> fetchTrainee() {
		
		return dao.findAll();
		
	}
	public void saveTrainee(Trainee trainee) {
		
		trainee.setPassword(encoder.encodeToString(trainee.getPassword().getBytes()));
		
		dao.save(trainee);
	}
	
	public void updateTrainee(Trainee trainee) {
		
		//Optional<Trainee> t13=dao.findById(trainee.getId());
		@SuppressWarnings("deprecation")
		Trainee t1=dao.getById(trainee.getId());
		System.out.println(trainee.getId());
		System.out.println(t1.getName());
		System.out.println(t1.getId());
		t1.setAddress(trainee.getAddress());
		t1.setAdharno(trainee.getAdharno());
		t1.setEmailid(trainee.getEmailid());
		t1.setAge(trainee.getAge());
		t1.setName(trainee.getName());
		t1.setJoiningdate(trainee.getJoiningdate());
		t1.setPhoneno(trainee.getPhoneno());
		t1.setUsername(trainee.getUsername());
		dao.save(t1);
		
	}
	public void deleteTrainee(int id) {
		@SuppressWarnings("deprecation")
		Trainee t1=dao.getById(id);
		System.out.println(t1.getId());
		//Owner o=dao.getOne(id);
//		System.out.println(o);
		dao.delete(t1);
		
	}
	
	public boolean isValidUser(String username,String password)
	{
		boolean status=false;
		try {
			Trainee trainee=dao.findTrainee(username);
			
			byte[] actualByte= Base64.getDecoder().decode(trainee.getPassword());
			String decriptedPassword= new String(actualByte); 
			
			
			if(trainee!=null && username.equals(trainee.getUsername()) && password.equals(decriptedPassword))
			{	
				System.out.println("Trainee found");
				return true;
				
			}
			else
			{
//				System.out.println("Trainee not found");
//				System.out.println(trainee!=null);
//				System.out.println(trainee.getUsername());
//				System.out.println(trainee.getPassword());
//				System.out.println(username.equals(trainee.getUsername()));
//				System.out.println(password.equals(trainee.getPassword()));
				return false;
			}
		}catch(Exception e) {
			
			e.printStackTrace();
				return false;
		}
		
	}
	
}