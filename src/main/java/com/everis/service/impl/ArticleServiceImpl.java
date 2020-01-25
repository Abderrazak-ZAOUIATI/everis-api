package com.everis.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.everis.dao.ArticleGenericDAO;
import com.everis.dao.entity.Article;
import com.everis.dao.entity.User;
import com.everis.service.ArticleService;
import com.everis.service.dto.ArticleDTO;
import com.everis.service.dto.UserDTO;
import com.everis.service.transformers.AbstractTransformer;
import com.everis.service.transformers.ArticleTransformer;
import com.everis.service.transformers.UserTransformer;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleGenericDAO articleGenericDAO;

	private AbstractTransformer<User, UserDTO> userTransformer = new UserTransformer();

	private AbstractTransformer<Article, ArticleDTO> articleTransformer = new ArticleTransformer(userTransformer);

	@Override
	public ArticleDTO create(ArticleDTO articleDTO) {

		Article article = articleTransformer.toEntity(articleDTO);
		Article articleResult = articleGenericDAO.create(article);

		return articleTransformer.toDTO(articleResult);
	}

	@Override
	public ArticleDTO update(ArticleDTO articleDTO) {

		Article article = articleTransformer.toEntity(articleDTO);
		Article articleResult = articleGenericDAO.update(article);

		ArticleDTO articleDTOResult = null;
		if (articleResult != null)
			articleDTOResult = articleTransformer.toDTO(articleResult);

		return articleDTOResult;
	}

	@Override
	public String delete(Integer k) {

		Article article = articleGenericDAO.delete(k);

		String result = "Error";
		if (article != null)
			result = "Success";

		return result;
	}

	@Override
	public Optional<ArticleDTO> getById(Integer k) {

		Optional<Article> articleOptional = articleGenericDAO.getById(k);

		Article article = null;
		ArticleDTO articleDTOResult = null;
		if (articleOptional.isPresent()) {
			article = articleOptional.get();
			articleDTOResult = articleTransformer.toDTO(article);
		}

		return Optional.ofNullable(articleDTOResult);
	}

	@Override
	public List<ArticleDTO> getAll() {

		List<Article> articles = articleGenericDAO.getAll();
		return articleTransformer.toDTOList(articles);
	}

	@Override
	public ArticleDTO changeArticleStatus(int articleId) {

		List<String> result = new ArrayList<>();
		
		Optional<Article> articleOptional = articleGenericDAO.getById(articleId);

		Article article = null;
		if (articleOptional.isPresent()) {
			
			article = articleOptional.get();
			article.setStatus(article.getStatus().equals("Active") ? "Inactive" : "Active");
			article = articleGenericDAO.update(article);
			result.add("Success");
		}

		return articleTransformer.toDTO(article);
	}

}
