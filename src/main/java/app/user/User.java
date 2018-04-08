package app.user;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import app.car.Car;

@Entity
public class User {
	@Id
	private String userId;
	private String userName;
	private String userEmail;
	private String userPhoneNumber;
	private Gender userGender;
	ArrayList<Car> userCarList;
	public User(String id, String name, String email, String phone,Gender gender) 
	{
		this.userId = id;
		this.userName = name;
		this.userEmail = email;
		this.userPhoneNumber = phone;
		this.userGender = gender;
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
}
