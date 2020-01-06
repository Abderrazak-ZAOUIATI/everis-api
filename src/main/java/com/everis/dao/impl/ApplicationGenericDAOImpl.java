package com.everis.dao.impl;

import org.springframework.stereotype.Component;

import com.everis.dao.ApplicationGenericDAO;
import com.everis.entity.Application;

@Component
public class ApplicationGenericDAOImpl extends GenericDAOImpl<Application,Integer> implements ApplicationGenericDAO {

	 public ApplicationGenericDAOImpl() {
	        super(Application.class);
	  }

} 
