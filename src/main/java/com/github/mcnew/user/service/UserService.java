package com.github.mcnew.user.service;

import com.github.mcnew.user.service.request.UserCreateRequest;
import com.github.mcnew.user.service.request.UserUpdateRequest;
import com.github.mcnew.user.service.response.UserCreateResponse;
import com.github.mcnew.user.service.response.UserResponse;

public interface UserService {

	UserCreateResponse save(UserCreateRequest request);

	UserResponse update(Integer id, UserUpdateRequest request);

	UserResponse find(Integer id);

	UserResponse delete(Integer id);

	Iterable<UserResponse> list();

}
