package com.issacamara.learning.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.issacamara.learning.messenger.database.DataBaseClass;
import com.issacamara.learning.messenger.model.Message;

public class MessageService {

	Map<Long, Message> messages = DataBaseClass.getMessages();
	
	
	
	public MessageService() {
		Message m1 = new Message(1L, "Issa", "Hi Issa !");
		Message m2 = new Message(2L, "Issa", "Hi Jordan !");
		Message m3 = new Message(3L, "Issa", "Hi Mark !");
		messages.put(1L, m1);
		messages.put(2L, m2);
		messages.put(3L, m3);
	}

	public List<Message> getAllMessages() {
		return new ArrayList<>(messages.values());
	}
	
	public List<Message> getAllMessagesForYear(int year) {
		return new ArrayList<>(messages.values());
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size) {
		return new ArrayList<>(messages.values());
	}
	
	public Message getMessage(Long id) {
		return messages.get(id);
	}

	public Message addMessage(Message m) {
		m.setId(messages.size() + 1);
		messages.put(m.getId(), m);
		return m;
	}

	public Message updateMessage(Message m) {
		if (m.getId() <= 0) {
			return null;
		}
		messages.put(m.getId(), m);
		return m;
	}

	public Message removeMessage(Message m) {
		return messages.remove(m.getId());
	}
}
