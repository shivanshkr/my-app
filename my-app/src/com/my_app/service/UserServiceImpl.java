package com.my_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.my_app.dao.UserDAO;
import com.my_app.model.User;

@Service("userService")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService{

	@Autowired
	UserDAO userDAO;
	
	
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public Integer addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		String username = user.getUsername();
		if (userDAO.checkUsername(username)) {
			throw new Exception("Username Already exits");
		}
		else {
			return userDAO.addUser(user);
		}
	}

}
