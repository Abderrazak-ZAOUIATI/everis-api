package com.everis.transformers;

import com.everis.dto.ApplicationDTO;
import com.everis.dto.OfferDTO;
import com.everis.entity.Application;
import com.everis.entity.Offer;

public class OfferTransformer extends AbstractTransformer<Offer, OfferDTO> {

	
	AbstractTransformer<Application, ApplicationDTO> abstractTransformerApplication;
	
	public OfferTransformer() {
	}

	public OfferTransformer(AbstractTransformer<Application, ApplicationDTO> abstractTransformerApplication) {
		
		this.abstractTransformerApplication = abstractTransformerApplication;

	}
	
	@Override
	public OfferDTO toDTO(Offer offer) {

		OfferDTO offerDTO = new OfferDTO();
		
		offerDTO.setId(offer.getId());
		offerDTO.setDescription(offer.getDescription());
		offerDTO.setNumberOfApplications(offer.getNumberOfApplications());
		offerDTO.setPublicationDate(offer.getPublicationDate());
		offerDTO.setStatus(offer.getStatus());
		offerDTO.setTitle(offer.getTitle());

		if(offer != null && offer.getApplications() != null && abstractTransformerApplication != null) 		
			offerDTO.setApplicationsDto(abstractTransformerApplication.toDTOList(offer.getApplications()));
			
		return offerDTO;
	}

	@Override
	public Offer toEntity(OfferDTO offerDTO) {

		Offer offer = new Offer();
		
		offer.setId(offerDTO.getId());
		offer.setDescription(offerDTO.getDescription());
		offer.setNumberOfApplications(offerDTO.getNumberOfApplications());
		offer.setPublicationDate(offerDTO.getPublicationDate());
		offer.setStatus(offerDTO.getStatus());
		offer.setTitle(offerDTO.getTitle());

		if(offerDTO != null && offerDTO.getApplicationsDto() != null && abstractTransformerApplication != null) 		
			offer.setApplications(abstractTransformerApplication.toEntityList(offerDTO.getApplicationsDto()));
			
		return offer;
		
	}

}
