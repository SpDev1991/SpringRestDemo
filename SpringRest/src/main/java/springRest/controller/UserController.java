package springRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springRest.services.*;
import springRest.models.UserDetails;

@RestController
public class UserController {
	
	private UserServices userServices;

	@Autowired
	public void setUserServices(UserServices userServices) {
		this.userServices = userServices;
	}
	
	@RequestMapping(value="/user/", method = RequestMethod.GET, headers= "Accept=application/json")
	public ResponseEntity<List<UserDetails>> listAllUser(){
		
		List<UserDetails> userList = userServices.listAllUser();
		if(userList.size() == 0)
		{
			return new ResponseEntity<List<UserDetails>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<UserDetails>>(userList,HttpStatus.OK);
	}

}
