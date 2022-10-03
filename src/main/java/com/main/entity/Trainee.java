package com.main.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Trainee")
public class Trainee {

	@Id
	@GeneratedValue
	
	@Column(name="TraineeId")
	private int id;
	@Column(name="Name")
	private String name;
	@Column(name="Age")
	private int age;
	@Column(name="Gender")
	private String gender;
	@Column(name="PhoneNo")
	private long phoneno;
	
	@Column(name="Email")
	private String emailid;
	
	@Column(name="AadharNo")
	private double adharno;
	@Column(name="JoiningDate")
	private LocalDate joiningdate;
	@Column(name="Password")
	private String password;
	@Column(name="Address")
	private String address;
	@Column(name="Username")
	private String username;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="workout_id")
	private WorkoutPlan workoutPlan;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="healthdetails_id")
	private HealthDetails healthDetails;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public double getAdharno() {
		return adharno;
	}

	public void setAdharno(double adharno) {
		this.adharno = adharno;
	}

	public LocalDate getJoiningdate() {
		return joiningdate;
	}

	public void setJoiningdate(LocalDate joiningdate) {
		this.joiningdate = joiningdate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public WorkoutPlan getWorkoutPlan() {
		return workoutPlan;
	}

	public void setWorkoutPlan(WorkoutPlan workoutPlan) {
		this.workoutPlan = workoutPlan;
	}

	public HealthDetails getHealthDetails() {
		return healthDetails;
	}

	public void setHealthDetails(HealthDetails healthDetails) {
		this.healthDetails = healthDetails;
	}
	
	
	}

