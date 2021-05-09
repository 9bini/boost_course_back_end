package org.edwith.webbe.securityexam.service;

import org.edwith.webbe.securityexam.config.ApplicationConfig;
import org.edwith.webbe.securityexam.config.SecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class, SecurityConfig.class })
public class PasswordEncoderTest {
	
	 // 테스트 순서를 컨트롤 할 수 없다.

	@Autowired
	PasswordEncoder passwordEncoder;

	@Test
	// junit4에서는 public을 필수로 붙여야되는 것 같다.
	public void passwordEncoder() {
		System.out.println(passwordEncoder.encode("1234"));
	}

	@Test
	public void passwordTest() {
		String encodePasswd = "$2a$10$mE8s2Vx9EVpGJ6381Kjs6eJw7SYiVHDYaBnBHtJPUp2yoV/vhmzKa";
		String password = "1234";
		boolean test = passwordEncoder.matches(password, encodePasswd);
		System.out.println(test);
	}

}
