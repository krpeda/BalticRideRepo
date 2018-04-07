package app.ride;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import app.car.Car;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	@OneToOne()
	private Car car;
	
	public Ride (String start, String end, Date time, int seats, double fee, Car car) {
		this.startPoint = start;
		this.endPoint = end;
		this.startTime = time;
		this.freeSeats = seats;
		this.rideFee = fee;
		this.car = car;
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
