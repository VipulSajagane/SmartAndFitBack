package com.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.main.entity.Trainee;
import com.main.entity.Trainer;

@Component
public interface TraineeDao extends JpaRepository<Trainee, Integer> {


	@Query("SELECT t FROM Trainee t WHERE t.username=?1")
	 Trainee findTrainee(String username);
	
}
