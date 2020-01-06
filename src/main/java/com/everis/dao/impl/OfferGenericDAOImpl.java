package com.everis.dao.impl;

import org.springframework.stereotype.Component;

import com.everis.dao.OfferGenericDAO;
import com.everis.entity.Offer;

@Component
public class OfferGenericDAOImpl extends GenericDAOImpl<Offer,Integer> implements OfferGenericDAO {

	 public OfferGenericDAOImpl() {
	        super(Offer.class);
	  }

} 
