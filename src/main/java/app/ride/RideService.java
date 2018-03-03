package app.ride;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;

import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.EntityPath;

@Service
public class RideService {
	
	private RideRepository rideRepository;
	private EntityManager em;

	public RideService(RideRepository rideRepository) {
		this.rideRepository = rideRepository;
	}

	Ride addRide(Ride ride) {
		// here you can do some validations etc before saving the user
		
		return rideRepository.save(ride);
	}
	List<Ride> getRidesByParam(String startpoint){
		TypedQuery<Ride> query = em.createQuery("SELECT * FROM Ride AS r WHERE r.startpoint = :startpoint", Ride.class);
		query.setParameter("startpoint", startpoint);
		List <Ride> foundedRides = (List<Ride>)query.getResultList();
		return foundedRides;
	}
	
	List<Ride> getAllRides() {
		return rideRepository.findAll();
	}

/*	User getUserById(long userId) {
		return RideRepository.findOne(userId);
	}*/
}