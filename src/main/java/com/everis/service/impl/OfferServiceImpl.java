package com.everis.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.dao.OfferGenericDAO;
import com.everis.dao.entity.Application;
import com.everis.dao.entity.Offer;
import com.everis.service.ApplicationService;
import com.everis.service.OfferService;
import com.everis.service.dto.ApplicationDTO;
import com.everis.service.dto.OfferDTO;
import com.everis.service.transformers.AbstractTransformer;
import com.everis.service.transformers.ApplicationTransformer;
import com.everis.service.transformers.OfferTransformer;

@Service
public class OfferServiceImpl implements OfferService {

	@Autowired
	private OfferGenericDAO offerGenericDAO;
	
	@Autowired
	private ApplicationService applicationService;

	private AbstractTransformer<Application, ApplicationDTO> applicationTransformer = new ApplicationTransformer();

	private AbstractTransformer<Offer, OfferDTO> offerTransformer = new OfferTransformer(applicationTransformer);

	@Override
	public OfferDTO create(OfferDTO offerDTO) {

		Offer offer = offerTransformer.toEntity(offerDTO);
		Offer offerResult = offerGenericDAO.create(offer);

		return offerTransformer.toDTO(offerResult);
	}

	@Override
	public OfferDTO update(OfferDTO offerDTO) {

		Offer offer = offerTransformer.toEntity(offerDTO);
		Offer offerResult = offerGenericDAO.update(offer);

		OfferDTO offerDTOResult = null;
		if (offerResult != null)
			offerDTOResult = offerTransformer.toDTO(offerResult);

		return offerDTOResult;
	}

	@Override
	public String delete(Integer k) {

		Offer offer = offerGenericDAO.delete(k);

		String result = "Error";
		if (offer != null)
			result = "Success";

		return result;
	}

	@Override
	public Optional<OfferDTO> getById(Integer k) {

		Optional<Offer> offerOptional = offerGenericDAO.getById(k);

		Offer offer = null;
		OfferDTO offerDTOResult = null;
		if (offerOptional.isPresent()) {
			offer = offerOptional.get();
			offerDTOResult = offerTransformer.toDTO(offer);
		}

		return Optional.ofNullable(offerDTOResult);
	}

	@Override
	public List<OfferDTO> getAll() {

		List<Offer> offers = offerGenericDAO.getAll();
		return offerTransformer.toDTOList(offers);
	}

	@Override
	public List<String> changeOfferStatus(int offerId) {

		List<String> result = new ArrayList<>();

		Optional<Offer> offerOptional = offerGenericDAO.getById(offerId);

		Offer offer = null;
		if (offerOptional.isPresent()) {

			offer = offerOptional.get();
			offer.setStatus(offer.getStatus().equals("Active") ? "Inactive" : "Active");
			offerGenericDAO.update(offer);
			result.add("Success");
		}

		return result;
	}

	@Override
	public List<ApplicationDTO> getOfferApplictions(int offerId) {
		
		List<ApplicationDTO> applicationsDTO = applicationService.getAll();
		List<ApplicationDTO> offerApplicationsDTO = new ArrayList<ApplicationDTO>();
		
		for(ApplicationDTO app:applicationsDTO) {
			
			if(app.getOfferDto().getId() == offerId) {
			offerApplicationsDTO.add(app);
			}
		}

		return offerApplicationsDTO;
	}

}
