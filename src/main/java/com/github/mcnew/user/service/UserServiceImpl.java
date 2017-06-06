package com.github.mcnew.user.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.mcnew.user.model.User;
import com.github.mcnew.user.repository.UserRepository;
import com.github.mcnew.user.service.request.UserCreateRequest;
import com.github.mcnew.user.service.request.UserUpdateRequest;
import com.github.mcnew.user.service.response.UserCreateResponse;
import com.github.mcnew.user.service.response.UserResponse;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserCreateResponse save(UserCreateRequest request) {
		User user = userRepository.findByUsername(request.getUsername());
		if (user == null) {
			user = new User();
			user.setActive(Boolean.TRUE);
			user.setUsername(request.getUsername());
			user.setPassword(hash(request.getPassword()));
			user.setName(request.getName());
			user.setSurname(request.getSurname());
			user.setSecondSurname(request.getSecondSurname());
			return new UserCreateResponse(false, userRepository.save(user));
		} else {
			return new UserCreateResponse(true, user);
		}
	}

	@Override
	public UserResponse update(Integer id, UserUpdateRequest request) {
		User user = userRepository.findOne(id);
		if (user == null) {
			return null;
		} else {
			user.setName(request.getName());
			user.setSurname(request.getSurname());
			user.setSecondSurname(request.getSecondSurname());
			user.setActive(request.getActive());
			return new UserResponse(userRepository.save(user));
		}
	}

	@Override
	public UserResponse find(Integer id) {
		User user = userRepository.findOne(id);
		if (user == null) {
			return null;
		} else {
			return new UserResponse(user);
		}
	}

	@Override
	public UserResponse delete(Integer id) {
		User user = userRepository.findOne(id);
		if (user == null) {
			return null;
		} else {
			user.setActive(Boolean.FALSE);
			return new UserResponse(userRepository.save(user));
		}
	}

	@Override
	public Iterable<UserResponse> list() {
		ArrayList<UserResponse> users = new ArrayList<>();
		userRepository.findAll().forEach(u -> users.add(new UserResponse(u)));
		return users;
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
