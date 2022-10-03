package com.main.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.entity.Trainee;
import com.main.entity.WorkoutPlan;
import com.main.service.WorkoutPlanService;



@CrossOrigin(origins ="http://localhost:3000/")
@RestController
public class WorkoutPlanController {
	
	@Autowired
	private WorkoutPlanService workoutPlanService;
	
	@PostMapping("/putWorkoutPlan")
	public WorkoutPlan getdata(@RequestBody WorkoutPlan workoutPlan)
	{
	
		//System.out.println(workoutPlan.getDay()+"  "+workoutPlan.getWorkoutDetails());
		workoutPlanService.saveWorkoutPlan(workoutPlan);
		
		return workoutPlan;
				
	}
	
	@PostMapping("/putWorkoutPlan/{id}")
	public boolean putdata(@PathVariable("id")  int id,@RequestBody WorkoutPlan workoutPlan)
	{
		//System.out.println(id+"........"+workoutPlan.getDay());
		
		boolean status=false;
		try {
		workoutPlanService.addWorkoutPlan(id,workoutPlan);
	    status=true;
		return status;
		}catch(Exception e){
			
			e.printStackTrace();
			return status;
		}
		
				
	}
	@GetMapping("/putWorkoutPlan/{id}")
	public boolean getdata(@PathVariable("id")  int id,@RequestBody WorkoutPlan workoutPlan)
	{
	//	System.out.println(id+"........"+workoutPlan.getDay());
		
		boolean status=false;
		try {
		workoutPlanService.addWorkoutPlan(id,workoutPlan);
		status=true;
		return status;
		}catch(Exception e){
			
		e.printStackTrace();
			return status;
	}
		
				
	}
	
	@GetMapping("/getAllWorkoutPlan")
	public List<WorkoutPlan> getdata()
	{
		
		return workoutPlanService.fetchWorkoutPlan();
	}
	
	
	@GetMapping("/getWorkoutPlan/{id}")
	public Optional<WorkoutPlan> getdata(@PathVariable("id")  int id)
	{
		
		return workoutPlanService.fetchOwner(id);
	}
	
	
	@PutMapping("/updateWorkoutPlan")
	public boolean getData(@RequestBody WorkoutPlan workoutPlan)
	{

		boolean status=true;
		try {
			workoutPlanService.updateWorkoutPlan(workoutPlan);
		}catch(Exception e) {
			e.printStackTrace();
			status=false;
		}
		return status;
	}



}


