package com.greydev.courseapi;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

	//can be injected either with 
	//property injection or constructor injection
	@Value("${app-mode}")
	private String appMode;

	@Autowired
	public ViewController(Environment environment) {
		this.appMode = environment.getProperty("app-mode");

	}

	@GetMapping("/")
	public String getMain(Model model) {

		model.addAttribute("datetime", new Date());
		model.addAttribute("username", "Jonathan ABC");
		model.addAttribute("mode", appMode);

		return "index";
	}

	@GetMapping("/mahmut")
	public String getMahmut() {
		return "mahmut";
	}

}
