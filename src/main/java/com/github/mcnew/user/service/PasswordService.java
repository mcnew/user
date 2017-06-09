package com.github.mcnew.user.service;

import com.github.mcnew.user.service.request.ChangePasswordRequest;
import com.github.mcnew.user.service.response.UserResponse;

public interface PasswordService {

	UserResponse changePassword(Integer id, ChangePasswordRequest request);

}
