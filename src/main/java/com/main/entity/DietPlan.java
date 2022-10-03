package com.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Dietplan")
public class DietPlan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int Dietid;
	
	private String Breakfast;
	
	private String Lunch;
	
	private String Dinner;

	public int getDietid() {
		return Dietid;
	}

	public void setDietid(int dietid) {
		Dietid = dietid;
	}

	public String getBreakfast() {
		return Breakfast;
	}

	public void setBreakfast(String breakfast) {
		Breakfast = breakfast;
	}

	public String getLunch() {
		return Lunch;
	}

	public void setLunch(String lunch) {
		Lunch = lunch;
	}

	public String getDinner() {
		return Dinner;
	}

	public void setDinner(String dinner) {
		Dinner = dinner;
	}
	
	
	
}
