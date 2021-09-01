package eci.edu.userServiceApp.repository;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import eci.edu.userServiceApp.model.User;

public interface UserRepository extends MongoRepository<User, String>{
	

	List<User> findByNameOrLastName(String name,String lastName);


	List<User> findByCreatedAtGreaterThan(Date date);
}
