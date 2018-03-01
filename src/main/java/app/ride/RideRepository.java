package app.ride;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRepository extends CrudRepository<Ride, Long>{
	@Override
	public List<Ride> findAll();
}