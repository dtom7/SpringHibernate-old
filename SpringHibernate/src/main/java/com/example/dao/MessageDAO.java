package com.example.dao;

import com.example.domain.Message;

public interface MessageDAO {

	Message createMessage(Message message);

	Message retrieveMessage(long id);

	boolean deleteMessage(long id);

	boolean updateMessage(Message message);

}
