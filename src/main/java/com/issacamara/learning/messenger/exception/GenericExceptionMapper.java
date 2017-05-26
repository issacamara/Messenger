package com.issacamara.learning.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.issacamara.learning.messenger.model.ErrorMessage;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exception) {
		ErrorMessage em = new ErrorMessage(exception.getMessage(), "https://www.google.com", 500);
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(em).build();
	}

}
