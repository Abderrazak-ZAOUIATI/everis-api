package com.everis.dao.impl;

import org.springframework.stereotype.Repository;
import com.everis.dao.ApplicationGenericDAO;
import com.everis.dao.entity.Application;

@Repository
public class ApplicationGenericDAOImpl extends GenericDAOImpl<Application, Integer> implements ApplicationGenericDAO {

	public ApplicationGenericDAOImpl() {
		super(Application.class);
	}
}
