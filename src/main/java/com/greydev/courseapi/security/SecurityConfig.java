package com.greydev.courseapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// user credentials will be stored in memory each time our application has started
		// later we will use a database 
		auth.inMemoryAuthentication()
				.withUser("admin").password(passwordEncoder().encode("admin123")).roles("ADMIN")
				.and()
				.withUser("can").password(passwordEncoder().encode("can123")).roles("USER");
	}

	// need to still protect our resources
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// require authentication for any resource: all views or api
		// and I want to use http basic 
		http.authorizeRequests().anyRequest().authenticated()
				.and()
				.httpBasic();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
