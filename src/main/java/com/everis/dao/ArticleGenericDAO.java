package com.everis.dao;

import org.springframework.stereotype.Repository;

import com.everis.entity.Article;

@Repository
public interface ArticleGenericDAO extends GenericDAO<Article,Integer> {
}
