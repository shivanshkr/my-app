package com.my_app.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my_app.entity.UserEntity;
import com.my_app.model.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Integer addUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		UserEntity userEntity = new UserEntity();
		userEntity.setName(user.getName());
		userEntity.setUsername(user.getUsername());
		userEntity.setPassword(user.getPassword());
		Integer userId = (Integer) session.save(userEntity);
		return userId;
	}
	
	@Override
	public Boolean checkUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		UserEntity userEntity = session.get(UserEntity.class, username);
		if (userEntity == null) {
			return false;
		}
		else {
			return true;
		}
	}
}
