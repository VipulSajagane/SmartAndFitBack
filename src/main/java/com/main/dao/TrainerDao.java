package com.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.main.entity.Trainee;
import com.main.entity.Trainer;

@Component
public interface TrainerDao extends JpaRepository<Trainer, Integer> 
{

	@Query("SELECT t FROM Trainer t WHERE t.username =? 1")
	Trainer findTrainer(String username);
}
