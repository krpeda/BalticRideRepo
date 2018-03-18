package app.car;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Car {
	@Id
	@GeneratedValue
	String carRegistrationNumber;
	String carModel;
	int carYear;
	public Car(String registration, String model, int year) {
		this.carRegistrationNumber = registration;
		this.carModel = model;
		this.carYear = year;
	}
}
