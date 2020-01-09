package com.everis.dao.impl;

import org.springframework.stereotype.Repository;
import com.everis.dao.ArticleGenericDAO;
import com.everis.dao.entity.Article;

@Repository
public class ArticleGenericDAOImpl extends GenericDAOImpl<Article, Integer> implements ArticleGenericDAO {

	public ArticleGenericDAOImpl() {
		super(Article.class);
	}

}
