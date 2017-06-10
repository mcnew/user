package com.github.mcnew.user.web.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.mcnew.user.service.PasswordService;
import com.github.mcnew.user.service.request.ChangePasswordRequest;
import com.github.mcnew.user.service.response.UserResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Administracion de claves")
@RestController
@RequestMapping("password")
public class PasswordController {

	private final PasswordService passwordService;

	@Autowired
	public PasswordController(PasswordService passwordService) {
		this.passwordService = passwordService;
	}

	@ApiOperation(value = "Cambio de clave", code = HttpServletResponse.SC_OK)
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, value = "{id}")
	public ResponseEntity<UserResponse> changePassword(@PathVariable("id") Integer id,
			@RequestBody ChangePasswordRequest request) {
		UserResponse response = passwordService.changePassword(id, request);
		if (response == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.accepted().body(response);
		}
	}

}
