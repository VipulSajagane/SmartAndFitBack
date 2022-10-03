package com.main.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.main.entity.DietPlan;
import com.main.service.DietPlanService;

@CrossOrigin(origins ="http://localhost:3000/")
@RestController
public class DietPlanController {
	
	@Autowired
	private DietPlanService dietPlanService;
		
	@GetMapping("/getDietPlan/{id}")
	public Optional<DietPlan> getDietPlan(@PathVariable("id")int id)
	{
		return dietPlanService.fetchDietPlan(id);
	}
}
