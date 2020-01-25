package com.everis.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.everis.dao.OfferGenericDAO;
import com.everis.dao.entity.Application;
import com.everis.dao.entity.Offer;

@Repository
public class OfferGenericDAOImpl extends GenericDAOImpl<Offer, Integer> implements OfferGenericDAO {

	public OfferGenericDAOImpl() {
		super(Offer.class);
	}
/*
	@SuppressWarnings("unchecked")
	@Override
	public List<Application> getOfferApplictions(int offerId) {

		this.openConnection();

		Query query = this.session.createQuery("from Application a left join fetch a.user u where a.offer.id =:offerId");

		query.setParameter("offerId", offerId);

		List<Application> applications = query.list();

		this.closeConnection();

		return applications;
	}*/

}