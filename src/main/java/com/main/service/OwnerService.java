package com.main.service;

import java.util.Base64;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.main.dao.OwnerDao;
import com.main.entity.Owner;
import com.main.entity.Trainer;

@Service
@Component
public class OwnerService {

	Base64.Encoder encoder = Base64.getEncoder();
	Base64.Decoder decoder = Base64.getDecoder();
	
	@Autowired
	private OwnerDao dao;
	
	public Optional<Owner> fetchOwner(int id) {
		

		Optional<Owner> o1=dao.findById(id);
		
		byte[] actualByte= Base64.getDecoder().decode(o1.get().getPassword());
		String actualString= new String(actualByte); 
		o1.get().setPassword(actualString);
		
		return o1;
		
	}
	
	public Owner getByName(String username)
	{
		return dao.findOwner(username);
	}
	
	public void saveOwner(Owner owner) {
		
		owner.setPassword(encoder.encodeToString(owner.getPassword().getBytes()));
		
		dao.save(owner);
		
	}
	
	public void updateOwner(Owner owner) {
			
			dao.save(owner);
	}
	
	public void deleteOwner(int id) {
		
		
		Owner o=dao.getOne(id);
		System.out.println(o);
		dao.delete(o);
	}
	
	
	public boolean isValidUser(String username,String password)
	{
		boolean status=false;
		try {
			Owner owner=dao.findOwner(username);
			byte[] actualByte= Base64.getDecoder().decode(owner.getPassword());
			String decriptedPassword= new String(actualByte); 
			
			System.out.println();
			if(owner!=null && username.equals(owner.getUsername()) && password.equals(decriptedPassword))
				return true;
			else
				return false;
			
		}catch(Exception e) {
			
			e.printStackTrace();
				return false;
		}
		
	}
	
	
}
