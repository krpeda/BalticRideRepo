package app.ride;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

import com.mysema.query.jpa.impl.JPAQuery;

@Service
public class RideService {
	
	private RideRepository rideRepository;

	public RideService(RideRepository rideRepository) {
		this.rideRepository = rideRepository;
	}

	Ride addRide(Ride ride) {
		// here you can do some validations etc before saving the user
		
		return rideRepository.save(ride);
	}

// TODO:
//	List<Ride> rideSearch  = new JPAQuery(rideRepository).from(ride)
//			   .where(user.name.like("%ov"))
//			   .groupBy(user.name)
//			   .list(user.name);

	List<Ride> getAllRides() {
		return rideRepository.findAll();
	}

/*	User getUserById(long userId) {
		return RideRepository.findOne(userId);
	}*/
}