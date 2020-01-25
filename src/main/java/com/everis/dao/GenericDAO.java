package com.everis.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface GenericDAO<T, K extends Serializable> {

	T create(T t);

	T update(T t); 

	T delete(K k);

	Optional<T> getById(K k);

	List<T> getAll();

}
