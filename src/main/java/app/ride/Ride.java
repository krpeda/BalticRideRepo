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
	String startpoint;
	String endpoint;
	Date starttime;
	int freeseats;
	double ridefee;
	public Ride (String start, String end, Date time, int seats, double fee) {
		this.startpoint = start;
		this.endpoint = end;
		this.starttime = time;
		this.freeseats = seats;
		this.ridefee = fee;

	}
	public String getstartpoint() {
		return startpoint;
	}
	public String getendpoint() {
		return endpoint;
	}
	public Date getstarttime() {
		return starttime;
	}
	public int getfreeseats() {
		return freeseats;
	}
	public double getridefee() {
		return ridefee;
	}
}
