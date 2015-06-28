package com.example.test;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.daotest.MessageDAO;
import com.example.domain.Message;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "applicationTestContext.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SpringTest {

	@Autowired
	private MessageDAO messageDAO = null;
	private static Message message = null;

	@Test
	public void test1MessageDAONotNull() {
		assertNotNull("messageDAO is null ..", this.messageDAO);
	}

	@Test
	public void test2CreateMessage() {
		SpringTest.message = messageDAO.createMessage(new Message(
				"Test Message"));
		assertNotNull(SpringTest.message.getId());
	}

	@Test
	public void test3RetrieveMessage() {
		assertNotNull(messageDAO.retrieveMessage(SpringTest.message.getId()));
	}

	@Test
	public void test4UpdateMessage() {
		assertEquals("Test Message", SpringTest.message.getText());
		SpringTest.message.setText("New Message");
		assertTrue(messageDAO.updateMessage(SpringTest.message));
		assertEquals("New Message",
				messageDAO.retrieveMessage(SpringTest.message.getId())
						.getText());
	}

	@Test
	public void test5DeleteMessage() {
		assertTrue(messageDAO.deleteMessage(SpringTest.message.getId()));
		assertNull(messageDAO.retrieveMessage(SpringTest.message.getId()));
	}
}
