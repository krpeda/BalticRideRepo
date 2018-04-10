package app.car;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
class CarRepositoryImpl implements CarRepositoryCustom {
	
	@PersistenceContext
    EntityManager em;

	public List<Car> findAllUserCars(String userId) {
		TypedQuery<Car> query = em.createQuery("FROM Car c WHERE c.userId = :userId", Car.class);
		List <Car> foundedCars = null;
		try {
			query.setParameter("userId", userId);
			foundedCars = query.getResultList();
		} catch (Exception e) {
			 //ignore
			 e.printStackTrace();
	    }
		return foundedCars;
	}
}