package com.github.mcnew.user.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UtilityServiceTest {

	private UtilityServiceImpl service;

	@Before
	public void setUp() {
		service = new UtilityServiceImpl();
	}

	@Test
	public void test() {
		Assert.assertEquals("JMnhXlKvxHwiW3V+e+4fnQ==", service.hash("user1"));
	}

}
