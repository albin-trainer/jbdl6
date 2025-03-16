package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration
@EnableMethodSecurity
public class SecurityConfig {
	@Autowired
	private PasswordEncoder encoder;
    @Bean
	public UserDetailsService userDetails() {
		InMemoryUserDetailsManager manager= new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername("user1").password(encoder.encode("1234")).roles("USER").build());
		manager.createUser(User.withUsername("user2").password(encoder.encode("1234")).roles("USER").build());
		manager.createUser(User.withUsername("user3").password(encoder.encode("1234")).roles("ADMIN").build());
		manager.createUser(User.withUsername("user4").password(encoder.encode("1234")).roles("ADMIN").build());
		return manager;
	}
}
