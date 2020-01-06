package com.everis.transformers;

import com.everis.dto.ApplicationDTO;
import com.everis.dto.ArticleDTO;
import com.everis.dto.UserDTO;
import com.everis.entity.Application;
import com.everis.entity.Article;
import com.everis.entity.User;

public class UserTransformer extends AbstractTransformer<User, UserDTO> {

	
	AbstractTransformer<Application, ApplicationDTO> abstractTransformerApplication;
	
	AbstractTransformer<Article, ArticleDTO> abstractTransformerArticle;

	public UserTransformer() {
	}

	public UserTransformer(AbstractTransformer<Application, ApplicationDTO> abstractTransformerApplication,AbstractTransformer<Article, ArticleDTO> abstractTransformerArticle) {
		
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

		if(user != null && user.getArticles() != null && abstractTransformerArticle != null) 		
			userDTO.setArticles(abstractTransformerArticle.toDTOList(user.getArticles()));
			
		if(user != null && user.getApplications() != null && abstractTransformerApplication != null) 		
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

		if(userDTO != null && userDTO.getArticles() != null && abstractTransformerArticle != null) 		
			user.setArticles(abstractTransformerArticle.toEntityList(userDTO.getArticles()));
			
		if(userDTO != null && userDTO.getApplications() != null && abstractTransformerApplication != null) 		
			user.setApplications(abstractTransformerApplication.toEntityList(userDTO.getApplications()));
			

		return user;
	}

}
