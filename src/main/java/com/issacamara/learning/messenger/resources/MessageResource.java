package com.issacamara.learning.messenger.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.issacamara.learning.messenger.model.Message;
import com.issacamara.learning.messenger.service.MessageService;

@Path("/messages")
public class MessageResource {
	
	MessageService ms = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages() {
		
		return ms.getAllMessages();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/{messageId}")
	public Message getMessages(@PathParam("messageId") long id) {	
		return ms.getMessage(id);
	}
}
