package com.github.mcnew.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.mcnew.user.service.UserRequest;
import com.github.mcnew.user.service.UserResponse;
import com.github.mcnew.user.service.UserService;

@Controller
@RequestMapping("users")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserResponse> create(@RequestBody UserRequest request) {
		UserResponse user = userService.save(request);
		if (user.isAlreadyExists()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(user);
		} else {
			return ResponseEntity.ok(user);
		}
	}

}
