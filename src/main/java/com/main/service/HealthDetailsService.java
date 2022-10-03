package com.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.main.dao.HealthDetailsDao;

import com.main.entity.HealthDetails;


@Service
@Component
public class HealthDetailsService {

	@Autowired
	private HealthDetailsDao dao;
	
	public Optional<HealthDetails> fetchHealthDetails(int id) {

		
		return dao.findById(id);
		
	}
	public void saveHealthDetails(HealthDetails healthDetails) {
		System.out.println(healthDetails.getHeight()+"  "+healthDetails.getWeight());
		dao.save(healthDetails);
	}
}
