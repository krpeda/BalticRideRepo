package app.car;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Car {
	@Id
	@GeneratedValue
<<<<<<< Upstream, based on branch 'master' of https://github.com/krpeda/BalticRideRepo.git
	private String carRegistrationNumber;
	private String carModel;
	private int carYear;
	public Car(String registration, String model, int year) {
=======
	int carId;
	String carRegistrationNumber;
	String carModel;
	int carYear;
	
	public Car(int id, String registration, String model, int year) {
		this.carId = id;
>>>>>>> c4774c4 Väiksed trikid, väiksed nipid (Car klass korda ja DateFormat)
		this.carRegistrationNumber = registration;
		this.carModel = model;
		this.carYear = year;
	}
<<<<<<< Upstream, based on branch 'master' of https://github.com/krpeda/BalticRideRepo.git
	public String getCarRegistrationNumber() {
		return carRegistrationNumber;
	}
	public String getCarModel() {
		return this.carModel;
	}
	public int getCarYear() {
		return this.carYear;
=======
	public Car(){
		
>>>>>>> c4774c4 Väiksed trikid, väiksed nipid (Car klass korda ja DateFormat)
	}
}
