package com.github.mcnew.user.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.mcnew.user.model.User;
import com.github.mcnew.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserResponse save(UserRequest request) {
		User user = userRepository.findByUsername(request.getUsername());
		if (user == null) {
			user = new User();
			user.setActive(Boolean.TRUE);
			user.setUsername(request.getUsername());
			user.setPassword(hash(request.getPassword()));
			user.setName(request.getName());
			user.setSurname(request.getSurname());
			user.setSecondSurname(request.getSecondSurname());
			return new UserResponse(false, userRepository.save(user));
		} else {
			return new UserResponse(true, user);
		}
	}

	String hash(String original) {
		try {
			return new String(
					Base64.getEncoder()
							.encode(MessageDigest.getInstance("MD5").digest(original.getBytes(StandardCharsets.UTF_8))),
					StandardCharsets.US_ASCII);
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalArgumentException(e);
		}
	}

}
