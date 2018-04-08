package app.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	public UserService(UserRepository repository) {
		this.userRepository = repository;
	}
	User addUser(User user) {
		return userRepository.save(user); 
	}
	List<User> getAllUsers() {
		return userRepository.findAll();
	}
}
