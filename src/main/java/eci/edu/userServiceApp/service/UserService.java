package eci.edu.userServiceApp.service;

import eci.edu.userServiceApp.dto.UserDto;
import eci.edu.userServiceApp.model.User;

import java.util.Date;
import java.util.List;

public interface UserService
{
    User create( User user );

    User findById( String id );

    List<User> all();

    boolean deleteById( String id );

    User update( UserDto userDto, String id );
    
    List<User> findUsersWithNameOrLastNameLike(String queryText);
    
    List<User> findUsersCreatedAfter(Date startDate);
}
