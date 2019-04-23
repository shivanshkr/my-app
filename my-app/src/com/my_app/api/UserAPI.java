package com.my_app.api;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.my_app.model.User;
import com.my_app.service.UserService;
import com.my_app.utility.ContextFactory;



@CrossOrigin
@RestController
@RequestMapping("userAPI")
public class UserAPI {
	
	
	@RequestMapping(method = RequestMethod.POST, value = "addUser" )
	public ResponseEntity<Integer> addUser(@RequestBody User user){
		try {
			UserService service = (UserService) ContextFactory.getContext().getBean("userService");
			Integer userId =  service.addUser(user);
			return new ResponseEntity<Integer>(userId, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			Integer userId  = 0;
			return new ResponseEntity<Integer>(userId, HttpStatus.BAD_REQUEST);
		}
		
	}
	public static void main(String[] args) throws Exception {
		User user = new User();
		String name = "Shivansh";
		String password = "Shivansh";
		String username = "Shivansh";
		user.setName(name);
		user.setPassword(password);
		user.setUsername(username);
//		try {
			UserService service = (UserService) ContextFactory.getContext().getBean("userService");

			Integer userId =  service.addUser(user);
			System.out.println(userId);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
////			Integer userId  = 0;
////			System.out.println(userId);
//		}
		
	}

}
