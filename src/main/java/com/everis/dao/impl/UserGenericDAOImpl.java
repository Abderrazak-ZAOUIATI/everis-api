package com.everis.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.everis.dao.UserGenericDAO;
import com.everis.dao.entity.User;

@Repository
public class UserGenericDAOImpl extends GenericDAOImpl<User, Integer> implements UserGenericDAO {

	private SessionFactory sessionFactory;
	private Session session;

	public UserGenericDAOImpl() {
		super(User.class);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public User getByEmailAndPassword(String email, String password) {

		this.sessionFactory = new Configuration().configure().buildSessionFactory();
		this.session = this.sessionFactory.openSession();
		this.session.beginTransaction();
		
		Query query = this.session.createQuery("from User where email=:email and password =:password");
		
		query.setParameter("email", email);
		query.setParameter("password", password);
		
		List<User> users = query.list();
		this.session.close();
		
		User user = new User();
		if(users != null && !users.isEmpty())
			user = users.get(0);
		 
		return user;
	}

}
