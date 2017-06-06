package com.github.mcnew.user.service.request;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("User Creation Request")
public class UserCreateRequest {

	@NotNull
	@ApiModelProperty(notes = "El nombre de usuario", required = true)
	private String username;

	@NotNull
	@ApiModelProperty(notes = "La clave", required = true)
	private String password;

	@NotNull
	@ApiModelProperty(notes = "El nombre de la persona", required = true)
	private String name;

	@NotNull
	@ApiModelProperty(notes = "El primer apellido", required = true)
	private String surname;

	@ApiModelProperty(notes = "El segundo apellido", required = false)
	private String secondSurname;

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname
	 *            the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the secondSurname
	 */
	public String getSecondSurname() {
		return secondSurname;
	}

	/**
	 * @param secondSurname
	 *            the secondSurname to set
	 */
	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

}
