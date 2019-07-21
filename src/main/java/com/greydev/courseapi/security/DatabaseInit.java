package com.greydev.courseapi.security;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DatabaseInit implements CommandLineRunner {

	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;

	public DatabaseInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void run(String... args) throws Exception {

		this.userRepository.deleteAll();
		User can = new User("can", passwordEncoder.encode("can123"), "USER", "");
		User admin = new User("admin", passwordEncoder.encode("admin123"), "ADMIN", "");
		User manager = new User("manager", passwordEncoder.encode("manager123"), "MANAGER", "");

		List<User> users = Arrays.asList(can, admin, manager);
		this.userRepository.saveAll(users);

	}

}
