package com.everis.dao.impl;

import org.springframework.stereotype.Component;

import com.everis.dao.ArticleGenericDAO;
import com.everis.entity.Article;

@Component
public class ArticleGenericDAOImpl extends GenericDAOImpl<Article,Integer> implements ArticleGenericDAO {

	 public ArticleGenericDAOImpl() {
	        super(Article.class);
	  }

} 
