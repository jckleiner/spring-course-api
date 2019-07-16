package com.greydev.courseapi.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublicRestApiController {

	@GetMapping("/api")
	public String index() {
		return "api/index";
	}

}
