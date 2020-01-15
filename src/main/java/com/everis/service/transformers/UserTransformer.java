package com.everis.service.transformers;

import com.everis.dao.entity.Application;
import com.everis.dao.entity.Article;
import com.everis.dao.entity.User;
import com.everis.service.dto.ApplicationDTO;
import com.everis.service.dto.ArticleDTO;
import com.everis.service.dto.UserDTO;

public class UserTransformer extends AbstractTransformer<User, UserDTO> {

	AbstractTransformer<Application, ApplicationDTO> abstractTransformerApplication;

	AbstractTransformer<Article, ArticleDTO> abstractTransformerArticle;

	public UserTransformer() {
	}

	public UserTransformer(AbstractTransformer<Application, ApplicationDTO> abstractTransformerApplication,
			AbstractTransformer<Article, ArticleDTO> abstractTransformerArticle) {

		this.abstractTransformerApplication = abstractTransformerApplication;
		this.abstractTransformerArticle = abstractTransformerArticle;

	}

	@Override
	public UserDTO toDTO(User user) {

		UserDTO userDTO = new UserDTO();

		userDTO.setId(user.getId());
		userDTO.setLastName(user.getLastName());
		userDTO.setFirstName(user.getFirstName());
		userDTO.setAddress(user.getAddress());
		userDTO.setEmail(user.getEmail());
		userDTO.setPhoneNumber(user.getPhoneNumber());
		userDTO.setPassword(user.getPassword());
		userDTO.setType(user.getType());
		userDTO.setCompteStatus(user.getCompteStatus());
		
		if (user.getArticles() != null && abstractTransformerArticle != null)
			userDTO.setArticles(abstractTransformerArticle.toDTOList(user.getArticles()));

		if (user.getApplications() != null && abstractTransformerApplication != null)
			userDTO.setApplications(abstractTransformerApplication.toDTOList(user.getApplications()));

		return userDTO;
	}

	@Override
	public User toEntity(UserDTO userDTO) {

		User user = new User();

		user.setId(userDTO.getId());
		user.setLastName(userDTO.getLastName());
		user.setFirstName(userDTO.getFirstName());
		user.setAddress(userDTO.getAddress());
		user.setEmail(userDTO.getEmail());
		user.setPhoneNumber(userDTO.getPhoneNumber());
		user.setPassword(userDTO.getPassword());
		user.setType(userDTO.getType());
		user.setCompteStatus(userDTO.getCompteStatus());

		if (userDTO.getArticles() != null && abstractTransformerArticle != null)
			user.setArticles(abstractTransformerArticle.toEntityList(userDTO.getArticles()));

		if (userDTO.getApplications() != null && abstractTransformerApplication != null)
			user.setApplications(abstractTransformerApplication.toEntityList(userDTO.getApplications()));

		return user;
	}

}
