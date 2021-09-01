package eci.edu.userServiceApp.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eci.edu.userServiceApp.dto.UserDto;
import eci.edu.userServiceApp.model.User;
import eci.edu.userServiceApp.repository.UserRepository;

@Service
public class UserServiceMongoDB implements UserService{
	
	private final UserRepository userRepository;
	   
    public UserServiceMongoDB(@Autowired UserRepository userRepository )
    {
        this.userRepository = userRepository;
    }

    @Override
    public User create( User user )
    {
        return userRepository.save(user);
    }

    @Override
    public User findById( String id )
    {
    	User user=null;
    	if(userRepository.existsById(id)) {
    		user = userRepository.findById(id).get();
    	}
        return user;
    }

    @Override
    public List<User> all()
    {
        return userRepository.findAll();
    }

    @Override
    public boolean deleteById( String id )
    {
    	boolean deleteUser=false;
    	if(userRepository.existsById(id)) {
    		userRepository.deleteById(id);
    		deleteUser=true;
    	}
        return deleteUser;
    }

    @Override
    public User update( UserDto userDto, String id ) {
        User user = null;
        if (userRepository.existsById(id)) {
            user = userRepository.findById(id).get();
            user.update(userDto);
            userRepository.save(user);
        }
        return user;
    }

	@Override
	public List<User> findUsersWithNameOrLastNameLike(String queryText) {

		return userRepository.findByNameOrLastName(queryText,queryText);//
	}

	@Override
	public List<User> findUsersCreatedAfter(Date startDate) {
		// TODO Auto-generated method stub
		return userRepository.findByCreatedAtGreaterThan(startDate);
	}

}
