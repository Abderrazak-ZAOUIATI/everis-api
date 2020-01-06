package com.everis.dao;

import org.springframework.stereotype.Repository;

import com.everis.entity.Offer;

@Repository
public interface OfferGenericDAO extends GenericDAO<Offer,Integer> {
}
