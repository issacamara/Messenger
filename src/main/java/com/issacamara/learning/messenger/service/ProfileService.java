package com.issacamara.learning.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.issacamara.learning.messenger.database.DataBaseClass;
import com.issacamara.learning.messenger.model.Profile;

public class ProfileService {

	Map<String, Profile> profiles = DataBaseClass.getProfiles();
	
	
	
	public ProfileService() {
		Profile p = new Profile(1L, "Issa", "Camara", "issacamara");
		profiles.put(p.getProfileName(), p);

	}

	public List<Profile> getAllProfiles() {
		return new ArrayList<>(profiles.values());
	}

	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}

	public Profile addProfile(Profile p) {
		p.setId(profiles.size() + 1);
		profiles.put(p.getProfileName(), p);
		return p;
	}

	public Profile updateProfile(Profile p) {
		if (p.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(p.getProfileName(), p);
		return p;
	}

	public Profile removeProfile(Profile p) {
		return profiles.remove(p.getProfileName());
	}
}
