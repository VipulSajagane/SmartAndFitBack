package com.main.service;

	import java.util.List;
import java.util.Optional;

	import javax.transaction.Transactional;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Component;
	import org.springframework.stereotype.Service;

import com.main.dao.TraineeDao;
import com.main.dao.WorkoutPlanDao;
import com.main.entity.Trainee;
import com.main.entity.WorkoutPlan;

	@Service
	@Component
	public class WorkoutPlanService {
		@Autowired
		private WorkoutPlanDao dao;
		
		@Autowired
		private TraineeDao traineedao;
		
		public Optional<WorkoutPlan> fetchOwner(int id) {
			
			return dao.findById(id);
			
		}
		public void saveWorkoutPlan(WorkoutPlan workoutPlan) {
			
			dao.save(workoutPlan);
		}
		
		public List<WorkoutPlan> fetchWorkoutPlan() {
			
			return dao.findAll();
			
		}
		
		public void updateWorkoutPlan(WorkoutPlan workoutPlan) {
		
			@SuppressWarnings("deprecation")
			WorkoutPlan w1= dao.getById(workoutPlan.getId());
		
//			w1.setDay(workoutPlan.getDay());
//			w1.setWorkout(workoutPlan.getWorkout());
//			w1.setWorkoutDetails(workoutPlan.getWorkoutDetails());
		    
			dao.save(w1);
		}
		
		
		public void addWorkoutPlan(int id, WorkoutPlan workoutPlan) {
			// TODO Auto-generated method stub
			
			Trainee t=traineedao.getById(id);
			
			t.setWorkoutPlan(workoutPlan);
			traineedao.save(t);
			
		}
			
	}




