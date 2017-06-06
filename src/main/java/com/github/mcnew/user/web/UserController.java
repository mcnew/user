package com.github.mcnew.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.mcnew.user.model.User;
import com.github.mcnew.user.service.UserService;

@Controller
@RequestMapping("users")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(method = { RequestMethod.POST }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<User> create(@RequestBody User user) {
		return ResponseEntity.ok(userService.save(user));
	}

}
