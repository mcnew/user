package com.github.mcnew.user.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.springframework.stereotype.Service;

@Service
public class UtilityServiceImpl implements UtilityService {

	@Override
	public String hash(String original) {
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
