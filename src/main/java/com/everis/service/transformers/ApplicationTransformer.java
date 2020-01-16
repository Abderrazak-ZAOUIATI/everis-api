package com.everis.service.transformers;

import com.everis.dao.entity.Application;
import com.everis.dao.entity.Offer;
import com.everis.dao.entity.User;
import com.everis.service.dto.ApplicationDTO;
import com.everis.service.dto.OfferDTO;
import com.everis.service.dto.UserDTO;

public class ApplicationTransformer extends AbstractTransformer<Application, ApplicationDTO> {

	AbstractTransformer<User, UserDTO> abstractTransformerUser;

	AbstractTransformer<Offer, OfferDTO> abstractTransformerOffer;

	public ApplicationTransformer() {
	}

	public ApplicationTransformer(AbstractTransformer<User, UserDTO> abstractTransformerUser,
			AbstractTransformer<Offer, OfferDTO> abstractTransformerOffer) {

		this.abstractTransformerUser = abstractTransformerUser;
		this.abstractTransformerOffer = abstractTransformerOffer;

	}

	@Override
	public ApplicationDTO toDTO(Application application) {

		ApplicationDTO applicationDTO = new ApplicationDTO();

		applicationDTO.setId(application.getId());
		applicationDTO.setStatus(application.getStatus());
		applicationDTO.setApplicationDate(application.getApplicationDate());

		if (application != null) {

			if (application.getUser() != null && abstractTransformerUser != null)
				applicationDTO.setUserDto(abstractTransformerUser.toDTO(application.getUser()));

			if (application.getOffer() != null && abstractTransformerOffer != null)
				applicationDTO.setOfferDto(abstractTransformerOffer.toDTO(application.getOffer()));

		}
		return applicationDTO;
	}

	@Override
	public Application toEntity(ApplicationDTO applicationDTO) {

		Application application = new Application();

		application.setId(applicationDTO.getId());
		application.setStatus(applicationDTO.getStatus());
		application.setApplicationDate(applicationDTO.getApplicationDate());

		if (applicationDTO != null) {

			if (applicationDTO.getUserDto() != null && abstractTransformerUser != null)
				application.setUser(abstractTransformerUser.toEntity(applicationDTO.getUserDto()));

			if (applicationDTO.getOfferDto() != null && abstractTransformerOffer != null)
				application.setOffer(abstractTransformerOffer.toEntity(applicationDTO.getOfferDto()));

		}

		return application;

	}

}
