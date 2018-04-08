package app.car;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Car {
	@Id
	@GeneratedValue
	private long carId;
	
	private String userId;
	private String carRegistrationNumber;
	private String carModel;
	private int carYear;

	public Car(long id, String registration, String model, int year, String userid) {
		this.carId = id;
		this.carRegistrationNumber = registration;
		this.carModel = model;
		this.carYear = year;
		this.userId = userid;
	}
	public Car() {

	}
	public String getCarRegistrationNumber() {
		return carRegistrationNumber;
	}
	public String getCarModel() {
		return this.carModel;
	}
	public int getCarYear() {
		return this.carYear;
	}
	public String getUserId() {
		return this.userId;
	}
	public long getCarId() {
		return this.carId;
	}
}
