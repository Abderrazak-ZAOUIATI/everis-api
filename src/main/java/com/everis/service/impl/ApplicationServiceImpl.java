package com.everis.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.dao.ApplicationGenericDAO;
import com.everis.dao.entity.Application;
import com.everis.dao.entity.Offer;
import com.everis.dao.entity.User;
import com.everis.service.ApplicationService;
import com.everis.service.dto.ApplicationDTO;
import com.everis.service.dto.OfferDTO;
import com.everis.service.dto.UserDTO;
import com.everis.service.transformers.AbstractTransformer;
import com.everis.service.transformers.ApplicationTransformer;
import com.everis.service.transformers.OfferTransformer;
import com.everis.service.transformers.UserTransformer;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	private ApplicationGenericDAO applicationGenericDAO;

	private AbstractTransformer<User, UserDTO> userTransformer = new UserTransformer();

	private AbstractTransformer<Offer, OfferDTO> offerTransformer = new OfferTransformer();

	private AbstractTransformer<Application, ApplicationDTO> applicationTransformer = new ApplicationTransformer(
			userTransformer, offerTransformer);

	@Override
	public ApplicationDTO create(ApplicationDTO applicationDTO) {

		Application application = applicationTransformer.toEntity(applicationDTO);
		Application applicationResult = applicationGenericDAO.create(application);
		ApplicationDTO applicationDTOResult = applicationTransformer.toDTO(applicationResult);

		return applicationDTOResult;
	}

	@Override
	public ApplicationDTO update(ApplicationDTO applicationDTO) {

		Application application = applicationTransformer.toEntity(applicationDTO);
		Application applicationResult = applicationGenericDAO.update(application);

		ApplicationDTO applicationDTOResult = null;
		if (applicationResult != null)
			applicationDTOResult = applicationTransformer.toDTO(applicationResult);

		return applicationDTOResult;
	}

	@Override
	public String delete(Integer k) {

		Application application = applicationGenericDAO.delete(k);

		String result = "Error";
		if (application != null)
			result = "Success";

		return result;
	}

	@Override
	public Optional<ApplicationDTO> getById(Integer k) {

		Optional<Application> applicationOptional = applicationGenericDAO.getById(k);

		Application application = null;
		ApplicationDTO applicationDTOResult = null;
		if (applicationOptional.isPresent()) {
			application = applicationOptional.get();
			applicationDTOResult = applicationTransformer.toDTO(application);
		}

		return Optional.ofNullable(applicationDTOResult);
	}

	@Override
	public List<ApplicationDTO> getAll() {

		List<Application> applications = applicationGenericDAO.getAll();
		List<ApplicationDTO> applicationsDTO = applicationTransformer.toDTOList(applications);

		return applicationsDTO;
	}

}
