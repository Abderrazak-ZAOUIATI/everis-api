package com.everis.dao;

import com.everis.dao.entity.User;

public interface UserGenericDAO extends GenericDAO<User,Integer> {

	User getByEmailAndPassword(String email, String password);
}
