package com.github.mcnew.user.web.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.mcnew.user.service.UserService;
import com.github.mcnew.user.service.request.UserCreateRequest;
import com.github.mcnew.user.service.request.UserUpdateRequest;
import com.github.mcnew.user.service.response.UserCreateResponse;
import com.github.mcnew.user.service.response.UserResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Administracion usuarios")
@RestController
@RequestMapping("users")
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@ApiOperation(value = "Crea un usuario", code = HttpServletResponse.SC_CREATED)
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserResponse> userCreate(@Validated @RequestBody UserCreateRequest request) {
		UserCreateResponse user = userService.save(request);
		if (user.isAlreadyExists()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(user);
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body(user);
		}
	}

	@ApiOperation(value = "Actualiza un usuario", code = HttpServletResponse.SC_ACCEPTED)
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, value = "{id}")
	public ResponseEntity<UserResponse> userUpdate(@PathVariable(name = "id", required = true) Integer id,
			@RequestBody UserUpdateRequest request) {
		LOGGER.debug("id a actualizar: {}", id);
		UserResponse response = userService.update(id, request);
		if (response == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.accepted().body(response);
		}
	}

	@ApiOperation(value = "Informacion del usuario", code = HttpServletResponse.SC_OK)
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "{id}")
	public ResponseEntity<UserResponse> userDetail(@PathVariable(name = "id", required = true) Integer id) {
		LOGGER.debug("id a mostrar: {}", id);
		UserResponse response = userService.find(id);
		if (response == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(response);
		}
	}

	@ApiOperation(value = "Baja usuario", code = HttpServletResponse.SC_OK)
	@RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, value = "{id}")
	public ResponseEntity<UserResponse> userDelete(@PathVariable(name = "id", required = true) Integer id) {
		LOGGER.debug("id a dar de baja: {}", id);
		UserResponse response = userService.delete(id);
		if (response == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(response);
		}
	}

	@ApiOperation(value = "Listado usuarios", code = HttpServletResponse.SC_OK)
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<UserResponse>> userList() {
		return ResponseEntity.ok(userService.list());
	}

}
