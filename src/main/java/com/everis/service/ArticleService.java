package com.everis.service;

import com.everis.service.dto.ArticleDTO;

public interface ArticleService extends GenericService<ArticleDTO, Integer>{	
	
	public ArticleDTO changeArticleStatus(int articleId);
}