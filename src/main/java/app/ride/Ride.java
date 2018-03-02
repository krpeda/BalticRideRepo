package app.ride;


import java.util.Date;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Ride {
	@Id
	@GeneratedValue
	long id;
	String startpoint;
	String endpoint;
	Date starttime;
	int freeseats;
	double ridefee;
}
