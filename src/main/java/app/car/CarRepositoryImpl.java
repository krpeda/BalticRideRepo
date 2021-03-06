package app.car;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
class CarRepositoryImpl implements CarRepositoryCustom {
	
	@PersistenceContext
	private
	EntityManager manager;

	public List<Car> findAllUserCars(String userId) {
		TypedQuery<Car> query = manager.createQuery("FROM Car c WHERE c.userId = :userId", Car.class);
		List <Car> foundCars = null;
		try {
			query.setParameter("userId", userId);
			foundCars = query.getResultList();
		} catch (Exception e) {
			 //ignore
			 e.printStackTrace();
	    }
		return foundCars;
	}
	public void removeCar(String carId) {
		Query query = manager.createQuery("DELETE FROM Car WHERE car_id = :carId");
		try {
			query.setParameter("carId", Long.parseLong(carId)).executeUpdate();
		} catch (Exception e) {
			//ignore
			e.printStackTrace();
		}
	}
}