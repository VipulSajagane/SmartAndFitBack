package com.main.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.main.entity.WorkoutPlan;
@Component
public interface WorkoutPlanDao extends JpaRepository<WorkoutPlan,Integer>{

}
