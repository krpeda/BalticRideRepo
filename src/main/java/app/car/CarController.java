package app.car;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class CarController {
	private CarService carService;
	
	public CarController(CarService service) {
		this.carService = service;
	}
	@RequestMapping(value = "/cars/add", method = RequestMethod.POST,
			consumes = "application/json")
	public Car addCar(@RequestBody Car car) {
		return carService.addCar(car);
	}
	@RequestMapping(value = "/cars", method=RequestMethod.GET)
	public List<Car> getAllCars(){
		return carService.getAllCars();
	}
	@RequestMapping(value ="/cars/{carId}/delete", method = RequestMethod.GET)
	public void removeCar(@PathVariable String carId) {carService.removeCar(carId);}
	@RequestMapping(value = "/user/{userId}/cars", method = RequestMethod.GET)
	public List<Car> getUserCars(@PathVariable String userId) {
		return carService.findById(userId);
	}
}
