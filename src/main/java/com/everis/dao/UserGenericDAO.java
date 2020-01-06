package com.everis.dao;

import org.springframework.stereotype.Repository;

import com.everis.entity.User;

@Repository
public interface UserGenericDAO extends GenericDAO<User,Integer> {
}
