package app.ride;

import java.util.Date;

import app.car.Car;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
public class Ride {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	private String startPoint;
	private String endPoint;
	@JsonDeserialize(using = CustomerDateAndTimeDeserialize.class)
	private Date startTime;
	private int freeSeats;
	private double rideFee;
	@OneToOne()
	@JsonProperty("rideCar")
	private Car rideCar;
	/* private ArrayList<User> users; */
	
	
	public Ride (String start, String end, Date time, int seats, double fee, Car rideCar) {
		this.startPoint = start;
		this.endPoint = end;
		this.startTime = time;
		this.freeSeats = seats;
		this.rideFee = fee;
		this.rideCar = rideCar;
	}
	public Ride() {
		
	}
	public String getStartPoint() {
		return startPoint;
	}
	public String getEndPoint() {
		return endPoint;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public int getFreeSeats() {
		return freeSeats;
	}
	public double getRideFee() {
		return rideFee;
	}
	public void setRideCar(Car car) {
		this.rideCar = car;
	}
	public Car getRideCar() {
		return rideCar;
	}
	
}
