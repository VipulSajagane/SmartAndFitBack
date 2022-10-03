package com.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.main.dao.DietPlanDao;
import com.main.entity.DietPlan;

@Service
@Component
public class DietPlanService {
	
	@Autowired
	private DietPlanDao dietPlaDao;

	
	public Optional<DietPlan> fetchDietPlan(int id)
	{
		return dietPlaDao.findById( id);
	}
}
