package app.ride;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;


@Service
public class RideService {
	@Autowired
	private RideRepository rideRepository;

	public RideService(RideRepository rideRepository) {
		this.rideRepository = rideRepository;
	}

	Ride addRide(Ride ride) {	
		/*String sDate = ride.getStartTime().toString();
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		try {
			ride.setStartTime(dateFormatter.parse(sDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}*/
		return rideRepository.save(ride);
	}
	List<Ride> findRidesByParam(String startpoint, String endpoint, Date datetime){
		return rideRepository.getRidesByParam(startpoint, endpoint, datetime);
	}
	public void removeRide(Ride ride) {
		rideRepository.delete(ride);
	}
	List<Ride> getAllRides() {
		return rideRepository.findAll();
	}
}