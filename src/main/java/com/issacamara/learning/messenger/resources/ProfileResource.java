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

import com.issacamara.learning.messenger.model.Profile;
import com.issacamara.learning.messenger.service.ProfileService;

@Path("/profiles")	
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {

	ProfileService ps = new ProfileService();

	@GET
	public List<Profile> getProfiles() {

		return ps.getAllProfiles();
	}

	@POST
	public Profile addProfiles(Profile p) {
		return ps.addProfile(p);
	}

	@GET
	@Path("/{ProfileName}")
	public Profile getProfiles(@PathParam("ProfileName") String profileName) {
		return ps.getProfile(profileName);
	}
	
	@PUT
	@Path("/{ProfileName}")
	public Profile updateProfiles(@PathParam("ProfileName") String profileName, Profile p) {
		p.setProfileName(profileName);
		return ps.updateProfile(p);
	}
	
	@DELETE
	@Path("/{ProfileName}")
	public void deleteProfiles(@PathParam("ProfileName") String profileName) {
		ps.removeProfile(ps.getProfile(profileName));
	}
}
