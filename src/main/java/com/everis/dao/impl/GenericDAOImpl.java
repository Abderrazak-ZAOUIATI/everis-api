package com.everis.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import com.everis.dao.GenericDAO;

@Repository
public class GenericDAOImpl<T, K extends Serializable> implements GenericDAO<T, K> {

	private Class<T> clazz;

	private Logger logger = Logger.getLogger(GenericDAOImpl.class);
	
	private SessionFactory sessionFactory;
	private Session session;

	public GenericDAOImpl(Class<T> clazz) {
		this.clazz = clazz;
	}

	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}

	public GenericDAOImpl() {
	}

	@Override
	public void openConnexion() {

		this.sessionFactory = new Configuration().configure().buildSessionFactory();
		this.session = this.sessionFactory.openSession();
		this.session.beginTransaction();

	}

	@Override
	public void closeConnexion() {
		this.session.clear();
		this.sessionFactory.close();

	}

	@Override
	public T create(T t) {

		openConnexion();
		this.session.save(t);
		this.session.getTransaction().commit();
		closeConnexion();

		return t;
	}

	@Override
	public T update(T t) {

		try {
			openConnexion();
			this.session.update(t);
			this.session.getTransaction().commit();
			closeConnexion();
			return t;

		} catch (Exception e) {
			logger.error("DataBase not available or the data not found, update() function");
			return null;
		}
	}

	@Override
	public T delete(K k) {

		try {

			openConnexion();

			T t = (T) this.session.get(this.clazz, k);
			this.session.delete(t);
			this.session.getTransaction().commit();

			closeConnexion();

			return t;
		} catch (Exception e) {
			logger.error("DataBase not available or the data not found");
			return null;
		}

	}

	@Override
	public Optional<T> getById(K k) {

		openConnexion();

		T t = (T) this.session.get(this.clazz, k);

		closeConnexion();

		return Optional.ofNullable(t);
	}

	@Override
	public List<T> getAll() {

		openConnexion();

		Query query = this.session.createQuery("from " + this.clazz.getName());

		List<T> tlist = query.list();

		closeConnexion();

		return tlist;
	}
}
