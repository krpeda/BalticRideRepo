package app.user;

import java.util.ArrayList;

import javax.persistence.Entity;

import app.car.Car;

@Entity
public class User {
	private String userId;
	private String userName;
	private String userEmail;
	private String userPhoneNumber;
	private Gender userGender;
	ArrayList<Car> userCarList;
	public User(String id, String name, String email, String phone,Gender gender,
			ArrayList<Car> carList) 
	{
		this.userId = id;
		this.userName = name;
		this.userEmail = email;
		this.userPhoneNumber = phone;
		this.userGender = gender;
		this.userCarList = carList;
	}
	public String getUserId() {
		return this.userId;
	}
	public String getUserName() {
		return this.userName;
	}
	public String getUserEmail() {
		return this.userEmail;
	}
	public String getUserPhoneNumber() {
		return this.userPhoneNumber;
	}
	public Gender getUserGender() {
		return this.userGender;
	}
	public ArrayList<Car> getUserCarList(){
		return this.userCarList;
	}
}
