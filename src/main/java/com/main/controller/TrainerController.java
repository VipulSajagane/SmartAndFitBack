package com.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.entity.Trainee;
import com.main.entity.Trainer;
import com.main.service.TrainerService;
@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class TrainerController {
	
	@Autowired
	private TrainerService trainerservice;
	
	@PostMapping("/addtrainer")
	public boolean addTrainer( @RequestBody Trainer trainer)
	{
		
		boolean status=true;
		try {
			trainerservice.addTrainer(trainer);
		}catch(Exception e) {
			e.printStackTrace();
			status=false;
		}
		return status;
		
	}
	@GetMapping("/getTrainerbyname/{username}")
	public Trainer findByUsername(@PathVariable("username") String username)
	{
		return trainerservice.fetchDataByName( username);
	}
	
	@GetMapping("/getTrainer/{id}")
	public Optional<Trainer> getdata(@PathVariable("id")  int id)
	{
		return trainerservice.fetchTrainer(id);
	}
	
	@RequestMapping("/getAllTrainer")
	public List<Trainer> getdataall()
	{
		
		return trainerservice.fetchAll();
	}
	

	@PutMapping("/updateTrainer")
	public boolean getdata(@RequestBody Trainer trainer)
	{
			System.out.println("update trainer......");
		boolean status=true;
		try {
			trainerservice.updateTrainer(trainer);
		}catch(Exception e) {
			e.printStackTrace();
			status=false;
		}
		return status;
	}
	
	@DeleteMapping("/deleteTrainer/{id}")
	public boolean deleteData(@PathVariable("id")  int id)
	{
		
		 boolean status=true;
			try {
				trainerservice.deleteTrainer(id);
			}catch(Exception e) {
				e.printStackTrace();
				status=false;
			}
			return status;
	}
}
