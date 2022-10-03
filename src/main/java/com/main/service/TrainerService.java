package com.main.service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.main.dao.TrainerDao;
import com.main.entity.Login;
import com.main.entity.Trainee;
import com.main.entity.Trainer;

@Service
@Component
public class TrainerService {
	
	@Autowired
	private TrainerDao dao;
	
	Base64.Encoder encoder = Base64.getEncoder();
	Base64.Decoder decoder = Base64.getDecoder();

	public void addTrainer(Trainer trainer) {
		// TODO Auto-generated method stub
		trainer.setPassword(encoder.encodeToString(trainer.getPassword().getBytes()));
		dao.save(trainer);
		
	}
	public Trainer fetchDataByName(String username)
	{
		return dao.findTrainer(username);
	}

	public Optional<Trainer> fetchTrainer(int id) {
		
		Optional<Trainer> t=dao.findById(id);
		
		byte[] actualByte= Base64.getDecoder().decode(t.get().getPassword());
		String actualString= new String(actualByte); 
		t.get().setPassword(actualString);
		
		return t;
	}

	public List<Trainer> fetchAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public void deleteTrainer(int id) {
		
		@SuppressWarnings("deprecation")
		Trainer t1=dao.getById(id);
		System.out.println(t1.getTrainerId());
		//Owner o=dao.getOne(id);
//		System.out.println(o);
		dao.delete(t1);
		
	}
	
public void updateTrainer(Trainer trainer) {
		
		//Optional<Trainee> t13=dao.findById(trainee.getId());
		@SuppressWarnings("deprecation")
		Trainer t1=dao.getById(trainer.getTrainerId());
		
		t1.setAddress(trainer.getAddress());
		t1.setAdharno(trainer.getAdharno());
		t1.setEmail(trainer.getEmail());
		t1.setAge(trainer.getAge());
		t1.setName(trainer.getName());
		t1.setJoiningdate(trainer.getJoiningdate());
		t1.setPhoneno(trainer.getPhoneno());
		t1.setUsername(trainer.getUsername());
		dao.save(t1);
		
	}

		public boolean isValidUser(String username,String password)
		{
			boolean status=false;
			try {
				Trainer trainer=dao.findTrainer(username);
				

				byte[] actualByte= Base64.getDecoder().decode(trainer.getPassword());
				String decriptedPassword= new String(actualByte); 
				
				
				if(trainer!=null && username.equals(trainer.getUsername()) && password.equals(decriptedPassword))
					return true;
				else
					return false;
				
			}catch(Exception e) {
				
				e.printStackTrace();
					return false;
			}
			
		}
	
}
