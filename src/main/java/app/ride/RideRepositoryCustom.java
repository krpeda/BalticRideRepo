package app.ride;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public interface RideRepositoryCustom {
	
	List<Ride> getRidesByParam(String startpoint, String endpoint, Date datetime);
	public void removeRide(String rideId);
}
