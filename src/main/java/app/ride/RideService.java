package app.ride;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RideService {
	private DateFormat dateFormatter;
	@Autowired
	private RideRepository rideRepository;

	public RideService(RideRepository rideRepository) {
		this.rideRepository = rideRepository;
	}

	Ride addRide(Ride ride) {	
		String sDate = ride.getStartTime().toString();
		dateFormatter = new SimpleDateFormat ("dd/MM/yyyy HH:mm");
		try {
			ride.setStartTime(dateFormatter.parse(sDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return rideRepository.save(ride);
	}
	List<Ride> findRidesByParam(String startpoint, String endpoint, Date datetime){
		return rideRepository.getRidesByParam(startpoint, endpoint, datetime);
	}
	
	List<Ride> getAllRides() {
		return rideRepository.findAll();
	}
}