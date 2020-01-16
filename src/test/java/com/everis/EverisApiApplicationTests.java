package com.everis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.everis.dao.ApplicationGenericDAO;
import com.everis.dao.ArticleGenericDAO;
import com.everis.dao.OfferGenericDAO;
import com.everis.dao.UserGenericDAO;
import com.everis.dao.entity.Application;
import com.everis.dao.entity.Article;
import com.everis.dao.entity.Offer;
import com.everis.dao.entity.User;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EverisApiApplicationTests {

	@Autowired
	UserGenericDAO userGenericDAO;

	@Autowired
	ArticleGenericDAO articelGenericDAO;
	
	@Autowired
	ApplicationGenericDAO applicationGenericDAO;
	
	@Autowired
	OfferGenericDAO offerGenericDAO;

	// Set userId and articleId (from database) to permit delete and update
	// functions.
	int articleId = 3;
	int userId = 3;
	
	int offerId=4;
	int apllicationId=4;

	// User DAO test
	@Test
	@Order(1)
	void createUser() {

		User user = new User("firstName", "lastName", "email", " password", " phoneNumber", "address", " type", null,
				null);

		User userResult = userGenericDAO.create(user);

		assertNotEquals(0, userResult.getId());
	}

	@Test
	@Order(2)
	void updateUser() {

		User user = new User(this.userId, "firstName updated", "lastName", "email", " password", " phoneNumber",
				"address", " type", null, null);

		User userResult = userGenericDAO.update(user);

		assertNotEquals(null, userResult);
	}

	@Test
	@Order(3)
	void getUser() {

		Optional<User> userResult = userGenericDAO.getById(this.userId);

		if (userResult.isPresent()) {
			assertNotEquals(userResult.get().getId(), 0);
		} else {
			assertEquals(true, false);
		}
	}

	@Test
	@Order(4)
	void getAllUsers() {

		List<User> users = userGenericDAO.getAll();

		assertNotEquals(null, users);
	}

	@Test
	@Order(5)
	void deleteUser() {

		User userResult = userGenericDAO.delete(this.userId);

		assertNotEquals(null, userResult);
	}

	// Article DAO tests

	@Test
	@Order(6)
	void createArticle() {

		User user = new User("firstName", "lastName", "email", " password", " phoneNumber", "address", " type", null,
				null);

		User userResult = userGenericDAO.create(user);

		Article article = new Article("title", " content", "mage", "publicationDae", "status", userResult);

		Article articleResult = articelGenericDAO.create(article);

		assertNotEquals(0, articleResult.getId());
	}

	@Test
	@Order(7)
	void updateArticle() {
		User user = new User("firstName", "lastName", "email", " password", " phoneNumber", "address", " type", null,
				null);

		User userResult = userGenericDAO.create(user);

		Article article = new Article(this.articleId, "title", " content", "mage", "publicationDae", "status",
				userResult);

		Article articleResult = articelGenericDAO.update(article);

		assertNotEquals(null, articleResult);
	}

	@Test
	@Order(8)
	void getArticle() {

		Optional<Article> articleResult = articelGenericDAO.getById(this.articleId);

		if (articleResult.isPresent()) {
			assertNotEquals(articleResult.get().getId(), 0);
		} else {
			assertEquals(true, false);
		}
	}

	@Test
	@Order(9)
	void getAllArticles() {

		List<Article> article = articelGenericDAO.getAll();

		assertNotEquals(null, article);
	}

	@Test
	@Order(10)
	void deleteArticle() {

		Article articleResult = articelGenericDAO.delete(this.articleId);

		assertNotEquals(null, articleResult);
	}

	// Application DAO test
	@Test
	@Order(11)
	void createApplication()
	{
		User user = new User("firstName", "lastName", "email", " password", " phoneNumber", "address", " type", null,null);
		User userResult = userGenericDAO.create(user);

		Offer offer = new Offer(0,"title","description","status","publicationDate",0,null);
		Offer offerResult = offerGenericDAO.create(offer);
		
		Application application = new Application(0,"applicationDate","status",userResult,offerResult);
		Application applicationResult = applicationGenericDAO.create(application);

		assertNotEquals(0, applicationResult.getId());
	}
	
	@Test
	@Order(12)
	void updateApplication() {

		User user = new User("firstName", "lastName", "email", " password", " phoneNumber", "address", " type", null,null);
		User userResult = userGenericDAO.create(user);
		
		Offer offer = new Offer(0,"title","description","status","publicationDate",0,null);
		Offer offerResult = offerGenericDAO.create(offer);
		
		Application application = new Application(this.apllicationId,"applicationDate","status",userResult,offerResult);
		Application applicationResult = applicationGenericDAO.update(application);

		assertNotEquals(null, applicationResult);
	}

	@Test
	@Order(13)
	void getApplication() {

		Optional<Application> applicationResult = applicationGenericDAO.getById(this.apllicationId);

		if (applicationResult.isPresent()) {
			assertNotEquals(applicationResult.get().getId(), 0);
		} else {
			assertEquals(true, false);
		}
	}

	@Test
	@Order(14)
	void getAllApplication() {

		List<Application> applications = applicationGenericDAO.getAll();

		assertNotEquals(null, applications);
	}

	@Test
	@Order(15)
	void deleteApplication() {

		Application applicationResult = applicationGenericDAO.delete(this.apllicationId);

		assertNotEquals(null, applicationResult);
	}
}