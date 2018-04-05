package app.ride;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.annotation.JsonFormat;

import app.car.Car;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Ride {
	@Id
	@GeneratedValue
	private long id;
	
	private String startPoint;
	private String endPoint;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date startTime;
	private int freeSeats;
	private double rideFee;
	
	public Ride (String start, String end, Date time, int seats, double fee) {
		this.startPoint = start;
		this.endPoint = end;
		this.startTime = time;
		this.freeSeats = seats;
		this.rideFee = fee;
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
}
