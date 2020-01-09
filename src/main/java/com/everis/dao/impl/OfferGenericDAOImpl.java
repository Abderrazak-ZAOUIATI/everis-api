package com.everis.dao.impl;

import org.springframework.stereotype.Repository;
import com.everis.dao.OfferGenericDAO;
import com.everis.dao.entity.Offer;

@Repository
public class OfferGenericDAOImpl extends GenericDAOImpl<Offer, Integer> implements OfferGenericDAO {

	public OfferGenericDAOImpl() {
		super(Offer.class);
	}

}
