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

import com.everis.dao.ArticleGenericDAO;
import com.everis.dao.UserGenericDAO;
import com.everis.entity.Article;
import com.everis.entity.User;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EverisApiApplicationTests {

	@Autowired
	UserGenericDAO userGenericDAO;

	@Autowired
	ArticleGenericDAO articelGenericDAO;

	//Set userId and articleId (from database) to permit delete and update functions.
	int articleId = 1;
	int userId = 1;

	
	
	//User DAO test
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

	
	//Application DAO test
}