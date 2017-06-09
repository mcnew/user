package com.github.mcnew.user.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.mcnew.user.model.Password;
import com.github.mcnew.user.model.User;
import com.github.mcnew.user.repository.PasswordRepository;
import com.github.mcnew.user.repository.UserRepository;
import com.github.mcnew.user.service.request.ChangePasswordRequest;
import com.github.mcnew.user.service.response.UserResponse;

@Service
public class PasswordServiceImpl implements PasswordService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PasswordServiceImpl.class);

	private final UserRepository userRepository;

	private final PasswordRepository passwordRepository;

	private final UtilityService utilityService;

	@Autowired
	public PasswordServiceImpl(UserRepository userRepository, PasswordRepository passwordRepository,
			UtilityService utilityService) {
		this.userRepository = userRepository;
		this.passwordRepository = passwordRepository;
		this.utilityService = utilityService;
	}

	@Override
	@Transactional
	public UserResponse changePassword(Integer id, ChangePasswordRequest request) {
		User user = userRepository.findOne(id);
		if (user == null) {
			return null;
		} else {
			String hash = utilityService.hash(request.getPassword());
			LOGGER.info("new: {}", hash);
			LOGGER.info("original: {}", user.getPassword());
			if (user.getPassword().equals(hash)) {
				return null;
			} else {
				List<Password> passwords = passwordRepository.findByActiveTrueAndUserOrderByCreation(user);
				if (!passwords.isEmpty()) {
					for (Password password : passwords) {
						LOGGER.info("historial: {}", password.getOld());
						if (password.getOld().equals(hash)) {
							return null;
						}
					}
					int length = passwords.size();
					if (length >= 5) {
						for (int i = 4; i < length; i++) {
							Password password = passwords.get(i);
							LOGGER.info("inactivel: {}", password.getOld());
							password.setActive(Boolean.FALSE);
							passwordRepository.save(password);
						}
					}
				}
				Password newOldEntry = new Password();
				newOldEntry.setOld(user.getPassword());
				newOldEntry.setUser(user);
				newOldEntry.setActive(Boolean.TRUE);
				passwordRepository.save(newOldEntry);
				user.setPassword(hash);
				userRepository.save(user);
				return new UserResponse(user);
			}
		}
	}

}
