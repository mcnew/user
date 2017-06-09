package com.github.mcnew.user.service.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("User Update Request")
public class UserUpdateRequest {

	@ApiModelProperty("Nombre de la persona")
	private String name;

	@ApiModelProperty("Primer apellido de la persona")
	private String surname;

	@ApiModelProperty("Segundo apellido de la persona")
	private String secondSurname;

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
