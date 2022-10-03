package com.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.main.entity.HealthDetails;


public interface HealthDetailsDao extends JpaRepository<HealthDetails,Integer> {

	//void save(HealthDetails healthDetails);
}