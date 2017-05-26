package com.issacamara.learning.messenger.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.issacamara.learning.messenger.model.Message;
import com.issacamara.learning.messenger.resources.beans.MessageFilterBean;
import com.issacamara.learning.messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService ms = new MessageService();

	@GET
	public List<Message> getMessages(@BeanParam MessageFilterBean mfb) {
		if (mfb.getYear() > 0) {
			return ms.getAllMessagesForYear(mfb.getYear());
		}
		return ms.getAllMessages();
	}

	@POST
	public Response addMessages(Message msg, @Context UriInfo uriInfo) {
		Message newMessage = ms.addMessage(msg);
		String newId = String.valueOf(newMessage.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri).entity(newMessage).build();
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

	@Path("/{messageId}/comments")
	public CommentResource getComments(@PathParam("messageId") long id) {
		return new CommentResource();
	}
}
