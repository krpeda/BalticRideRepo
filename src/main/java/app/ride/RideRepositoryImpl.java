package app.ride;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
class RideRepositoryImpl implements RideRepositoryCustom {
	
    @PersistenceContext
    EntityManager em;

	@Override
	public List<Ride> getRidesByParam(String startpoint, String endpoint, Date datetime) {
		TypedQuery<Ride> query = em.createQuery("FROM Ride r WHERE r.start_point = :startpoint AND r.end_point = :endpoint AND r.start_time >= :datetime", Ride.class);
		List <Ride> foundedRides = null;
		try {
			 query.setParameter("startpoint", startpoint);
			 query.setParameter("endpoint", endpoint);
			 query.setParameter("datetime", datetime);
			 foundedRides = query.getResultList();
	    } catch (Exception e) {
			 //ignore
			 e.printStackTrace();
	    }
		return foundedRides;
	}

	

	/*@Override
	public List<Ride> getRidesByParam(String startpoint, String endpoint, Date datetime) {
		TypedQuery<Ride> query = em.createQuery("FROM Ride r WHERE r.startpoint = :startpoint", Ride.class);
		
		List <Ride> foundedRides = null;
		try {
			 foundedRides = query.setParameter("startpoint", startpoint).getResultList();
	    } catch (Exception e) {
			 //ignore
			 e.printStackTrace();
	    }
		return foundedRides;
	}*/
}

    
