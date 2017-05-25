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

import com.issacamara.learning.messenger.model.Comment;
import com.issacamara.learning.messenger.service.CommentService;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {

	private CommentService cs = new CommentService();

	@GET
	public List<Comment> getComments(@PathParam("messageId") long messageId) {

		return cs.getAllComments(messageId);
	}

	@POST
	public Comment addComments(@PathParam("messageId") long messageId, Comment c) {
		return cs.addComment(messageId, c);
	}

	@GET
	@Path("/{commentId}")
	public Comment getComments(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
		return cs.getComment(messageId, commentId);
	}

	@PUT
	@Path("/{commentId}")
	public Comment updateComments(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId,
			Comment c) {
		c.setId(commentId);
		return cs.updateComment(messageId, c);
	}

	@DELETE
	@Path("/{commentId}")
	public void deleteComments(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
		cs.removeComment(messageId, cs.getComment(messageId, commentId));
	}

}
