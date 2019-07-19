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
				.withUser("admin")
				.password(passwordEncoder().encode("admin123"))
				.roles("ADMIN")
				.authorities("ACCESS_TEST1", "ACCESS_TEST2")
				.and()
				.withUser("can")
				.password(passwordEncoder().encode("can123"))
				.roles("USER")
				.and()
				.withUser("manager")
				.password(passwordEncoder().encode("manager123"))
				.roles("MANAGER")
				.authorities("ACCESS_TEST1");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/").permitAll() // no auth needed to access
				.antMatchers("/profile/**").authenticated()
				.antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/management/**").hasAnyRole("ADMIN", "MANAGER")
				.antMatchers("/api/test1").hasAuthority("ACCESS_TEST1")
				.antMatchers("/api/test2").hasAuthority("ACCESS_TEST2")
				.and()
				.httpBasic();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
