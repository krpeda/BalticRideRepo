package app.car;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Car {
	@Id
	@GeneratedValue
	private int carId;
	private String carRegistrationNumber;
	private String carModel;
	private int carYear;
	public Car(int id, String registration, String model, int year) {
		this.carId = id;
		this.carRegistrationNumber = registration;
		this.carModel = model;
		this.carYear = year;
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
}
