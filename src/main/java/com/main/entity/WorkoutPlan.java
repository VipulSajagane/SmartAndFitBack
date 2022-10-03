package com.main.entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="WorkoutPlan")
public class WorkoutPlan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="WorkoutPlanId")
	private int id;
	
	
	@Column(name="Day1")
	private String day1;

	private String workout1;
	
	private String workoutDetails1;
	@Column(name="Day2")
	private String day2;

	private String workout2;
	
	private String workoutDetails2;
	@Column(name="Day3")
	private String day3;

	private String workout3;
	
	private String workoutDetails3;
	@Column(name="Day4")
	private String day4;

	private String workout4;
	
	private String workoutDetails4;

	@Column(name="Day5")
	private String day5;

	private String workout5;
	
	private String workoutDetails5;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="trainee_id")
	private Trainee trainee;

	public Trainee getTrainee() {
		return trainee;
	}

	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDay1() {
		return day1;
	}

	public void setDay1(String day1) {
		this.day1 = day1;
	}

	public String getWorkout1() {
		return workout1;
	}

	public void setWorkout1(String workout1) {
		this.workout1 = workout1;
	}

	public String getWorkoutDetails1() {
		return workoutDetails1;
	}

	public void setWorkoutDetails1(String workoutDetails1) {
		this.workoutDetails1 = workoutDetails1;
	}

	public String getDay2() {
		return day2;
	}

	public void setDay2(String day2) {
		this.day2 = day2;
	}

	public String getWorkout2() {
		return workout2;
	}

	public void setWorkout2(String workout2) {
		this.workout2 = workout2;
	}

	public String getWorkoutDetails2() {
		return workoutDetails2;
	}

	public void setWorkoutDetails2(String workoutDetails2) {
		this.workoutDetails2 = workoutDetails2;
	}

	public String getDay3() {
		return day3;
	}

	public void setDay3(String day3) {
		this.day3 = day3;
	}

	public String getWorkout3() {
		return workout3;
	}

	public void setWorkout3(String workout3) {
		this.workout3 = workout3;
	}

	public String getWorkoutDetails3() {
		return workoutDetails3;
	}

	public void setWorkoutDetails3(String workoutDetails3) {
		this.workoutDetails3 = workoutDetails3;
	}

	public String getDay4() {
		return day4;
	}

	public void setDay4(String day4) {
		this.day4 = day4;
	}

	public String getWorkout4() {
		return workout4;
	}

	public void setWorkout4(String workout4) {
		this.workout4 = workout4;
	}

	public String getWorkoutDetails4() {
		return workoutDetails4;
	}

	public void setWorkoutDetails4(String workoutDetails4) {
		this.workoutDetails4 = workoutDetails4;
	}

	public String getDay5() {
		return day5;
	}

	public void setDay5(String day5) {
		this.day5 = day5;
	}

	public String getWorkout5() {
		return workout5;
	}

	public void setWorkout5(String workout5) {
		this.workout5 = workout5;
	}

	public String getWorkoutDetails5() {
		return workoutDetails5;
	}

	public void setWorkoutDetails5(String workoutDetails5) {
		this.workoutDetails5 = workoutDetails5;
	}
	

	
	
}
