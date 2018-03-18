package app.ride;


import java.util.Date;
import org.springframework.boot.autoconfigure.SpringBootApplication;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ride {
	@Id
	@GeneratedValue
	long id;
	String startPoint;
	String endPoint;
	String startTime;
	int freeSeats;
	double rideFee;
	public Ride (String start, String end, String time, int seats, double fee) {
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
	public String getStartTime() {
		return startTime;
	}
	public int getFreeSeats() {
		return freeSeats;
	}
	public double getRideFee() {
		return rideFee;
	}
}
