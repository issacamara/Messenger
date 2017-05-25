package com.issacamara.learning.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemo {

	@GET
	@Path("annotations")
	public String getParam(@MatrixParam("param") String matrix, @HeaderParam("customHeader") String header,
			@CookieParam("name") String cookie) {

		return "Matrix=" + matrix + "\nHeader=" + header + "\nCookie=" + cookie;
	}

	@GET
	@Path("context")
	public String getParam(@Context UriInfo uri, @Context HttpHeaders headers) {

		return "Path=" + uri.getAbsolutePath().toString() + "\nCookies=" + headers.getCookies().toString();
	}
}
