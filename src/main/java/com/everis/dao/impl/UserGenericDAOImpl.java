package com.everis.dao.impl;

import org.springframework.stereotype.Component;

import com.everis.dao.UserGenericDAO;
import com.everis.entity.User;

@Component
public class UserGenericDAOImpl extends GenericDAOImpl<User,Integer> implements UserGenericDAO {

	 public UserGenericDAOImpl() {
	        super(User.class);
	  }

} 
