package com.everis.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.everis.dao.UserGenericDAO;
import com.everis.dao.entity.Application;
import com.everis.dao.entity.Article;
import com.everis.dao.entity.User;
import com.everis.service.SendVerificationCode;
import com.everis.service.UserService;
import com.everis.service.dto.ApplicationDTO;
import com.everis.service.dto.ArticleDTO;
import com.everis.service.dto.UserDTO;
import com.everis.service.transformers.AbstractTransformer;
import com.everis.service.transformers.ApplicationTransformer;
import com.everis.service.transformers.ArticleTransformer;
import com.everis.service.transformers.UserTransformer;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserGenericDAO userGenericDAO;

	private AbstractTransformer<Application, ApplicationDTO> applicationTransformer = new ApplicationTransformer();

	private AbstractTransformer<Article, ArticleDTO> articleTransformer = new ArticleTransformer();

	private AbstractTransformer<User, UserDTO> userTransformer = new UserTransformer(applicationTransformer,
			articleTransformer);

	@Override
	public UserDTO create(UserDTO userDTO) {

		User user = userTransformer.toEntity(userDTO);
		user.setType("Candidate");
		//Create verification code
		String verificationCode = UUID.randomUUID().toString().replace("-", "");
		user.setCompteStatus(verificationCode);
		
		User userResult = userGenericDAO.create(user);
		
		if(userResult.getId() != 0)
		{
			String name = user.getLastName().toUpperCase();
			name += " "+user.getFirstName().substring(0, 1).toUpperCase();
			name +=user.getFirstName().substring(1, user.getFirstName().length());
			
			SendVerificationCode.sendCodeVerification(name, userResult.getEmail(), verificationCode);
		}
		
		return userTransformer.toDTO(userResult);
	}

	@Override
	public UserDTO update(UserDTO userDTO) {

		User user = userTransformer.toEntity(userDTO);
		User userResult = userGenericDAO.update(user);

		UserDTO userDTOResult = null;
		if (userResult != null)
			userDTOResult = userTransformer.toDTO(userResult);

		return userDTOResult;
	}

	@Override
	public String delete(Integer k) {

		User user = userGenericDAO.delete(k);

		String result = "Error";
		if (user != null)
			result = "Success";

		return result;
	}

	@Override
	public Optional<UserDTO> getById(Integer k) {

		Optional<User> userOptional = userGenericDAO.getById(k);

		User user = null;
		UserDTO userDTOResult = null;
		if (userOptional.isPresent()) {
			user = userOptional.get();
			userDTOResult = userTransformer.toDTO(user);
		}

		return Optional.ofNullable(userDTOResult);
	}

	@Override
	public List<UserDTO> getAll() {

		List<User> users = userGenericDAO.getAll();

		return userTransformer.toDTOList(users);
	}

	@Override
	public UserDTO getByEmailAndPassword(UserDTO userDto) {
		
		String email = userDto.getEmail();
		String password = userDto.getPassword();
		User user = userGenericDAO.getByEmailAndPassword(email,password);
	    
		return userTransformer.toDTO(user);
	}

	@Override
	public List<String> confirmAccount(int userId, String verificationCode) {
		
		List<String> response = new ArrayList<>();
		
		Optional<User> userOptional = userGenericDAO.getById(userId);
		if(userOptional.isPresent()) {
			User user = userOptional.get();
			if(user.getCompteStatus().equals(verificationCode)) {
				response.add("OK");
				user.setCompteStatus("Activated");
				userGenericDAO.update(user);
			}
			else {
				response.add("NOK");
			}
		}
		return response;
	}
	
}
