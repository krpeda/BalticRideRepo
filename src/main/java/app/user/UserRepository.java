package app.user;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.car.Car;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
		@Override
		public List<User> findAll();
		public User findOne(String userId);
	}

