package com.github.mcnew.user.service.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.mcnew.user.model.User;

public class UserCreateResponse extends UserResponse {

	@JsonIgnore
	private boolean alreadyExists;

	public UserCreateResponse(boolean alreadyExists, User user) {
		super(user);
		this.alreadyExists = alreadyExists;
	}

	/**
	 * @return the alreadyExists
	 */
	public boolean isAlreadyExists() {
		return alreadyExists;
	}

	/**
	 * @param alreadyExists
	 *            the alreadyExists to set
	 */
	public void setAlreadyExists(boolean alreadyExists) {
		this.alreadyExists = alreadyExists;
	}

}
