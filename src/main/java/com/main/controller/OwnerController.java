package com.main.controller;

import java.util.Optional;

import javax.persistence.Access;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.dao.OwnerDao;
import com.main.entity.Owner;
import com.main.service.OwnerService;
@CrossOrigin(origins ="http://localhost:3000/")
@RestController
public class OwnerController {
	@Autowired
	private OwnerService ownerService;
	@Autowired
	private OwnerDao dao;
	
	@GetMapping("/getOwner/{id}")
	public Optional<Owner> getdata(@PathVariable("id")  int id)
	{
		
		return ownerService.fetchOwner(id);
	}
	
	@PostMapping("/putOwner")
	public Owner getdata(@RequestBody Owner owner)
	{
		System.out.println("In owner");
		ownerService.saveOwner(owner);
		return owner;
				
	}
	
	@GetMapping("/getOwnerByName/{username}")
	public Owner getdata(@PathVariable("username")  String username)
	{
		
		return ownerService.getByName(username);
	}
	
	@PutMapping("/updateOwner")
	public String updateData(@RequestBody Owner owner)
	{
		ownerService.updateOwner(owner);
		
		return "Successfully Updated";
				
	}
	
	@DeleteMapping("/delete-owner")
	public String deleteData(@PathVariable("id")  int id)
	{
		
		
		//ownerService.deleteOwner(id);
		ownerService.deleteOwner(id);
		return "Successfully Deleted";
				
	}

}
