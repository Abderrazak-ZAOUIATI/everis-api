package com.everis.dao.impl;

import org.springframework.stereotype.Repository;
import com.everis.dao.UserGenericDAO;
import com.everis.dao.entity.User;

@Repository
public class UserGenericDAOImpl extends GenericDAOImpl<User, Integer> implements UserGenericDAO {

	public UserGenericDAOImpl() {
		super(User.class);
	}

}
