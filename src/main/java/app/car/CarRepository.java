package app.car;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import app.ride.Ride;
import app.ride.RideRepositoryCustom;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {
	@Override
	public List<Car> findAll();
}
