package app.user;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.car.Car;

@RestController
public class UserController {
	private UserService userService;
	
	public UserController(UserService service) {
		this.userService = service;
	}
	@RequestMapping(value="/user/add", method=RequestMethod.POST,
			consumes="application/json")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
}
