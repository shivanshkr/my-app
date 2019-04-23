package com.my_app.dao;

import com.my_app.model.User;

public interface UserDAO {
	public Integer addUser(User user);
	public Boolean checkUsername(String username);
}
