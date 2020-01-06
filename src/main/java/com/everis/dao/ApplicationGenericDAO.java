package com.everis.dao;

import org.springframework.stereotype.Repository;

import com.everis.entity.Application;

@Repository
public interface ApplicationGenericDAO extends GenericDAO<Application,Integer> {
}
