package com.everis.service;

import java.util.List;
import java.util.Optional;

public interface GenericService<T, K> {

	T create(T t);

	T update(T t);

	String delete(K k);

	Optional<T> getById(K k);

	List<T> getAll();

}
