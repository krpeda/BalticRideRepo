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
	@RequestMapping(value="/cars/add", method=RequestMethod.POST,
			consumes="application/json")
	public Car addCar(Car car) {
		return carService.addCar(car);
	}
	@RequestMapping(value="/cars", method=RequestMethod.GET,
			 consumes="application/json")
	public List<Car> getAllCars(){
		return carService.getAllCars();
	}
}