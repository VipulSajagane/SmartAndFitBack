package com.main.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.entity.HealthDetails;
import com.main.entity.Owner;
import com.main.service.HealthDetailsService;
@CrossOrigin(origins ="http://localhost:3000/")
@RestController
public class HealthDetailsController {

	private HealthDetailsService healthDetailsService;
	
	@GetMapping("/getHealthDetails/{id}")
	public Optional<HealthDetails> getdata(@PathVariable("id")  int id)
	{
		
		return healthDetailsService.fetchHealthDetails(id);
	}
	
	@PostMapping("/putHealthDetails")
	public HealthDetails getdata(@RequestBody HealthDetails healthDetails)
	{
		System.out.println(healthDetails.getHeight()+" "+healthDetails.getWeight());
		healthDetailsService.saveHealthDetails(healthDetails);
		
		return healthDetails;
				
	}
	
}
