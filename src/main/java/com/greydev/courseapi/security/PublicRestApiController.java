package com.greydev.courseapi.security;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PublicRestApiController {

	private UserRepository userRepository;

	public PublicRestApiController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	// to test if everything works
	@GetMapping("/users")
	public List<User> allUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/test1")
	public String test1() {
		return "api test 1";
	}

	@GetMapping("/test2")
	public String test2() {
		return "api test 2";
	}

	public void test() {

		int[] a = { 1, 2, 3 };

		List<Integer> myList = Arrays.stream(a)
				.boxed()
				.collect(Collectors.toList());

		Collections.sort(myList);

		// Object source_arr, int sourcePos, Object dest_arr, int destPos, int len
		//		System.arraycopy(arg0, arg1, arg2, arg3, arg4);

	}

}
