package com.issacamara.learning.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.issacamara.learning.messenger.database.DataBaseClass;
import com.issacamara.learning.messenger.model.Comment;
import com.issacamara.learning.messenger.model.Message;

public class CommentService {
	
	Map<Long, Message> messages = DataBaseClass.getMessages();
	
	public List<Comment> getAllComments(Long messageId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<>(comments.values());
	}
	
	public Comment getComment(Long messageId, Long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		
		return comments.get(commentId);
	}

	public Comment addComment(Long messageId, Comment c) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		c.setId(comments.size()+1);
		comments.put(c.getId(), c);
		return c;
	}

	public Comment updateComment(Long messageId, Comment c) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if (c.getId() <= 0) {
			return null;
		}
		comments.put(c.getId(), c);
		return c;
	}

	public Comment removeComment(Long messageId, Comment c) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(c.getId());
	}
}
