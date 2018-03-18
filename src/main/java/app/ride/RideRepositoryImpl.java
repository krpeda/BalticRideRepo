package app.ride;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class RideRepositoryImpl implements RideRepositoryCustom {
	
    @PersistenceContext
    EntityManager em;

	@Override
	public List<Ride> getRidesByParam(String startpoint) {
		TypedQuery<Ride> query = em.createQuery("FROM Ride r WHERE r.startpoint = :startpoint", Ride.class);
		
		List <Ride> foundedRides = null;
		try {
			 foundedRides = query.setParameter("startpoint", startpoint).getResultList();
	    } catch (Exception e) {
			 //ignore
			 e.printStackTrace();
	    }
		return foundedRides;
	}
}

    
