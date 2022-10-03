package com.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.main.entity.DietPlan;



@Component
public interface DietPlanDao extends JpaRepository<DietPlan,Integer>
{

}

