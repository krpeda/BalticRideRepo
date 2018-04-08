package app.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {
	@Autowired
	private CarRepository carRepository;
	public CarService(CarRepository repository) {
		this.carRepository = repository;
	}
	Car addCar(Car car) {
		return carRepository.save(car); 
	}
	List<Car> getAllCars() {
		return carRepository.findAll();
	}
	public List<Car> findById(String userId) {
		return carRepository.findAllUserCars(userId);
	}
}
