package com.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.main.entity.Owner;
import com.main.entity.Trainer;
@Component
public interface OwnerDao extends JpaRepository<Owner,Integer>
 {
	@Query("SELECT o FROM Owner o WHERE o.username =? 1")
	Owner findOwner(String username);

}


