package eci.edu.userServiceApp.service;

import eci.edu.userServiceApp.dto.UserDto;
import eci.edu.userServiceApp.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


public class UserServiceHashMap
    implements UserService
{

    private final HashMap<String, User> usersMap = new HashMap<>();


    @Override
    public User create( User user )
    {
        usersMap.put( user.getId(), user );
        return user;
    }

    @Override
    public User findById( String id )
    {
        if ( usersMap.containsKey( id ) )
        {
            return usersMap.get( id );
        }
        return null;
    }

    @Override
    public List<User> all()
    {
        return new ArrayList<>( usersMap.values() );
    }

    @Override
    public boolean deleteById( String id )
    {
        return usersMap.remove( id ) != null;
    }

    @Override
    public User update( UserDto userDto, String id )
    {
        if ( usersMap.containsKey( id ) )
        {
            User user = usersMap.get( id );
            user.update( userDto );
            return user;
        }
        else
        {
            return null;
        }
    }

	@Override
	public List<User> findUsersWithNameOrLastNameLike(String queryText) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findUsersCreatedAfter(Date startDate) {
		// TODO Auto-generated method stub
		return null;
	}


}
