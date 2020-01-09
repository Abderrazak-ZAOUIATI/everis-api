package com.everis.service.transformers;

import com.everis.dao.entity.Article;
import com.everis.dao.entity.User;
import com.everis.service.dto.ArticleDTO;
import com.everis.service.dto.UserDTO;

public class ArticleTransformer extends AbstractTransformer<Article, ArticleDTO> {

	AbstractTransformer<User, UserDTO> abstractTransformerUser;

	public ArticleTransformer() {
	}

	public ArticleTransformer(AbstractTransformer<User, UserDTO> abstractTransformerUser) {

		this.abstractTransformerUser = abstractTransformerUser;

	}

	@Override
	public ArticleDTO toDTO(Article article) {

		ArticleDTO articleDTO = new ArticleDTO();

		articleDTO.setId(article.getId());
		articleDTO.setTitle(article.getTitle());
		articleDTO.setContent(article.getContent());
		articleDTO.setPublicationDate(article.getPublicationDate());
		articleDTO.setImage(article.getImage());
		articleDTO.setPublicationDate(article.getPublicationDate());
		articleDTO.setStatus(article.getStatus());

		if (article != null && article.getUser() != null && abstractTransformerUser != null)
			articleDTO.setUserDto(abstractTransformerUser.toDTO(article.getUser()));

		return articleDTO;
	}

	@Override
	public Article toEntity(ArticleDTO articleDTO) {

		Article article = new Article();

		article.setId(articleDTO.getId());
		article.setTitle(articleDTO.getTitle());
		article.setContent(articleDTO.getContent());
		article.setPublicationDate(articleDTO.getPublicationDate());
		article.setImage(articleDTO.getImage());
		article.setPublicationDate(articleDTO.getPublicationDate());
		article.setStatus(articleDTO.getStatus());

		if (articleDTO != null && articleDTO.getUserDto() != null && abstractTransformerUser != null)
			article.setUser(abstractTransformerUser.toEntity(articleDTO.getUserDto()));

		return article;

	}

}
