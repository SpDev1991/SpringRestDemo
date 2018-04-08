package springRest.dao;

import java.util.List;

import springRest.models.UserDetails;

public interface UserDao {
	
	public List<UserDetails> listAllUser();
	
	public void addUser(UserDetails user);
	
	public void updateUser(UserDetails user);
	
	public void deleteUser(UserDetails user);
	
	public UserDetails findUserById(UserDetails user);

}
