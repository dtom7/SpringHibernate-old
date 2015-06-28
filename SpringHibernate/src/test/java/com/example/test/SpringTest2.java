package com.example.test;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.example.domain.Book;
import com.example.domain.Library;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "applicationTestContext.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SpringTest2 {

	@Autowired
	@Qualifier("mysql")
	private PlatformTransactionManager transactionManager = null;
	@Autowired
	@Qualifier("sessionFactory2")
	private SessionFactory sessionFactory = null;

	@Test
	public void test1TransactionManagerNotNull() {
		assertNotNull("transactionManager is null ..", this.transactionManager);
	}

	@Test
	public void test2SessionFactoryNotNull() {
		assertNotNull("sessionFactory is null ..", this.sessionFactory);
	}

	@Test
	public void test3() {

		Library library;
		Book book;
		TransactionDefinition definition;
		TransactionStatus status;

		definition = new DefaultTransactionDefinition();
		status = transactionManager.getTransaction(definition);
		try {
			Session session = this.sessionFactory.getCurrentSession();
			assertNotNull("session is null1 ..", session);
			book = new Book("New Book1");
			library = new Library("New Library1");
			library.getBooks().add(book);
			book.setLibrary(library);
			session.save(library);
			transactionManager.commit(status);
			assertFalse("session is not closed1 ..", session.isOpen());
		} catch (Exception e) {
			System.out.println("Exception1 .. ");
			System.out.println(e.getMessage());
			transactionManager.rollback(status);
			throw new RuntimeException(e);
		}

		definition = new DefaultTransactionDefinition();
		status = transactionManager.getTransaction(definition);
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session = this.sessionFactory.getCurrentSession();
			assertNotNull("session is null2 ..", session);
			//library.getBooks().remove(0);
			library = (Library) session.get(Library.class, 1L);
			transactionManager.commit(status);
			assertFalse("session is not closed2 ..", session.isOpen());
		} catch (Exception e) {
			System.out.println("Exception2 .. ");
			System.out.println(e.getMessage());
			transactionManager.rollback(status);
			throw new RuntimeException(e);
		}
	
		definition = new DefaultTransactionDefinition();
		status = transactionManager.getTransaction(definition);
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session = this.sessionFactory.getCurrentSession();
			assertNotNull("session is null3 ..", session);
			//library.getBooks().remove(0);
			library = (Library) session.get(Library.class, 1L);
			System.out.println("Size: " + library.getBooks().size());
			transactionManager.commit(status);
			assertFalse("session is not closed3 ..", session.isOpen());
		} catch (Exception e) {
			System.out.println("Exception3 .. ");
			System.out.println(e.getMessage());
			transactionManager.rollback(status);
			throw new RuntimeException(e);
		}
		
	}

}
