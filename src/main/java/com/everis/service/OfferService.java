package com.everis.service;

import java.util.List;

import com.everis.service.dto.ApplicationDTO;
import com.everis.service.dto.OfferDTO;

public interface OfferService extends GenericService<OfferDTO, Integer>{	
	
	public List<String> changeOfferStatus(int offerId);
	List<ApplicationDTO> getOfferApplictions(int offerId);	
}