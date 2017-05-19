package com.issacamara.learning.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.issacamara.learning.messenger.model.Message;
import com.issacamara.learning.messenger.service.MessageService;

@Path("/messages")	
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService ms = new MessageService();

	@GET
	public List<Message> getMessages() {

		return ms.getAllMessages();
	}

	@POST
	public Message addMessages(Message msg) {
		return ms.addMessage(msg);
	}

	@GET
	@Path("/{messageId}")
	public Message getMessages(@PathParam("messageId") long id) {
		return ms.getMessage(id);
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessages(@PathParam("messageId") long id, Message msg) {
		msg.setId(id);
		return ms.updateMessage(msg);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void deleteMessages(@PathParam("messageId") long id) {
		ms.removeMessage(ms.getMessage(id));
	}
}
