package springRest.services;

import java.util.List;

import springRest.models.UserDetails;

public interface UserServices {

public List<UserDetails> listAllUser();
	
	public void addUser(UserDetails user);
	
	public void updateUser(UserDetails user);
	
	public void deleteUser(UserDetails user);
	
	public UserDetails findUserById(UserDetails user);
}
