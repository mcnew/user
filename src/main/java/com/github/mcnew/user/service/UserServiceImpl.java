package com.github.mcnew.user.service;

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
	public User save(User user) {
		return userRepository.save(user);
	}

}
