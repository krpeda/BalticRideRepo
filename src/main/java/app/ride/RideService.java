package app.ride;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RideService {
	@Autowired
	private RideRepository rideRepository;

	public RideService(RideRepository rideRepository) {
		this.rideRepository = rideRepository;
	}

	Ride addRide(Ride ride) {
		// here you can do some validations etc before saving the user
		
		return rideRepository.save(ride);
	}
	List<Ride> findRidesByParam(String startpoint){
		return rideRepository.getRidesByParam(startpoint);
	}
	
	List<Ride> getAllRides() {
		return rideRepository.findAll();
	}
}