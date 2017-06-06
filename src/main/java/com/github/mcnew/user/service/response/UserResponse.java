package com.github.mcnew.user.service.response;

import com.github.mcnew.user.model.User;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("User Response")
public class UserResponse {

	@ApiModelProperty("El id de base de datos")
	private Integer id;

	@ApiModelProperty("Estado del usuario")
	private Boolean active;

	@ApiModelProperty("El nombre del usuario")
	private String username;

	@ApiModelProperty("La contrasena")
	private String password;

	@ApiModelProperty("El nombre de la persona")
	private String name;

	@ApiModelProperty("El primer apellido")
	private String surname;

	@ApiModelProperty("El segundo apellido")
	private String secondSurname;

	public UserResponse(User user) {
		id = user.getId();
		active = user.getActive();
		username = user.getUsername();
		password = "****";
		name = user.getName();
		surname = user.getSurname();
		secondSurname = user.getSecondSurname();
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * @param active
	 *            the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

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
