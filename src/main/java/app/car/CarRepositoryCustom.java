package app.car;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface CarRepositoryCustom {
	
	public List<Car> findAllUserCars(String userId);
}
