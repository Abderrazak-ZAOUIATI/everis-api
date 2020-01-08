package com.everis.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.everis.dao.OfferGenericDAO;
import com.everis.dto.ApplicationDTO;
import com.everis.dto.OfferDTO;
import com.everis.entity.Application;
import com.everis.entity.Offer;
import com.everis.service.OfferService;
import com.everis.transformers.AbstractTransformer;
import com.everis.transformers.ApplicationTransformer;
import com.everis.transformers.OfferTransformer;

@Service
public class OfferServiceImpl implements OfferService{

	@Autowired
	private OfferGenericDAO offerGenericDAO;
	
	private AbstractTransformer<Application,ApplicationDTO> applicationTransformer = new ApplicationTransformer();
		
	private AbstractTransformer<Offer,OfferDTO> offerTransformer = new OfferTransformer(applicationTransformer);

	@Override
	public OfferDTO create(OfferDTO offerDTO) {

		Offer offer = offerTransformer.toEntity(offerDTO);
		Offer offerResult = offerGenericDAO.create(offer);
		OfferDTO offerDTOResult = offerTransformer.toDTO(offerResult);
		
		return offerDTOResult;
	}

	@Override
	public OfferDTO update(OfferDTO offerDTO) {
		
		Offer offer = offerTransformer.toEntity(offerDTO);
		Offer offerResult = offerGenericDAO.update(offer);
		
		OfferDTO offerDTOResult = null;
		if(offerResult != null)
			offerDTOResult = offerTransformer.toDTO(offerResult);
		
		return offerDTOResult;
	}

	@Override
	public String delete(Integer k) {
		
		Offer offer = offerGenericDAO.delete(k);
		
		String result = "Error";
		if(offer != null)
			result = "Success";
	
		return result;
	}

	@Override
	public Optional<OfferDTO> getById(Integer k) {
		
		Optional<Offer> offerOptional = offerGenericDAO.getById(k);
	
		Offer offer = null;
		OfferDTO offerDTOResult = null;
		if(offerOptional.isPresent())
		{
			offer = offerOptional.get();
			offerDTOResult = offerTransformer.toDTO(offer);
		}

		return Optional.ofNullable(offerDTOResult);
	}

	@Override
	public List<OfferDTO> getAll() {
		
		List<Offer> offers = offerGenericDAO.getAll();
		List<OfferDTO> offersDTO = offerTransformer.toDTOList(offers);
		return offersDTO;
	}
	
}
