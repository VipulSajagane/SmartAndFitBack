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
import org.springframework.web.bind.annotation.RestController;
import com.main.entity.Trainee;
import com.main.service.TraineeService;
@CrossOrigin(origins ="http://localhost:3000/")
@RestController
public class TraineeController {
	@Autowired
	private TraineeService traineeService;
	
	@GetMapping("/getTrainee/{id}")
	public Optional<Trainee> getdata(@PathVariable("id")  int id)
	{
		
		return traineeService.fetchTrainee(id);
	}
	
	@GetMapping("/getTraineeByName/{username}")
	public Trainee getdataByName(@PathVariable("username")  String username)
	{
		
		return traineeService.getTrainer(username);
	}
	
	
	@PutMapping("/updateTrainee")
	public boolean getdata(@RequestBody Trainee trainee)
	{

		boolean status=true;
		try {
		traineeService.updateTrainee(trainee);
		}catch(Exception e) {
			e.printStackTrace();
			status=false;
		}
		return status;
	}
	
	
	@GetMapping("/getAllTrainee")
	public List<Trainee> getdata()
	{
		
		return traineeService.fetchTrainee();
	}
	
	@PostMapping("/addTrainee")
	public boolean addTraninee(@RequestBody Trainee trainee)
	{
		boolean status=true;
		try {
		traineeService.saveTrainee(trainee);
		}catch(Exception e) {
			e.printStackTrace();
			status=false;
		}
		return status;
	}
	
	@DeleteMapping("/deleteTrainee/{id}")
	public boolean deleteData(@PathVariable("id")  int id)
	{
		
		 boolean status=true;
			try {
				 traineeService.deleteTrainee(id);
			}catch(Exception e) {
				e.printStackTrace();
				status=false;
			}
			return status;
	}

}
