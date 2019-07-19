package com.greydev.courseapi.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PublicRestApiController {

	@GetMapping("/test1")
	public String test1() {
		return "api test 1";
	}

	@GetMapping("/test2")
	public String test2() {
		return "api test 2";
	}

}
