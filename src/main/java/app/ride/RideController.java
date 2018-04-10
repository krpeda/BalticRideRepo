package app.ride;

import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class RideController {
    
	private RideService rideService;
	
	public RideController(RideService rideService) {
		this.rideService = rideService;
	}
	@RequestMapping(value = "/rides/add", method = RequestMethod.POST,
			consumes = "application/json")
	public Ride addRide(@RequestBody Ride ride) {
		return rideService.addRide(ride);
	}
    @RequestMapping(value = "/rides", method = RequestMethod.GET)
	public List<Ride> getAllRides() {
		return rideService.getAllRides();
	}
	@RequestMapping(value = "/rides/{rideId}/delete", method = RequestMethod.DELETE)
	public void removeRide(@PathVariable String rideId) {rideService.removeRide(rideId);}
    @RequestMapping(value = "/search/{startpoint}/{endpoint}/{datetime}", method = RequestMethod.GET)
	public List<Ride> getRidesByParam(@PathVariable String startpoint, @PathVariable String endpoint, @PathVariable Date datetime) {
		return rideService.findRidesByParam(startpoint, endpoint, datetime);
	}
    
}

