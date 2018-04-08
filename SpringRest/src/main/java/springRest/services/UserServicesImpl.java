package springRest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import springRest.models.UserDetails;
import springRest.dao.*;

public class UserServicesImpl implements UserServices {
	
	
	private UserDao userDao;

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public List<UserDetails> listAllUser() {
		return userDao.listAllUser();
	}

	public void addUser(UserDetails user) {
		
		 userDao.addUser(user);
	}

	public void updateUser(UserDetails user) {

		userDao.updateUser(user);
	}

	public void deleteUser(UserDetails user) {
		
		userDao.deleteUser(user);
	}

	public UserDetails findUserById(UserDetails user) {
		return userDao.findUserById(user);
	}

}
