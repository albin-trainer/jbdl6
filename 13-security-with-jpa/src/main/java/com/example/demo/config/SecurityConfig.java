package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@EnableMethodSecurity
@Configuration
public class SecurityConfig {
	@Autowired
	private UserDetailsService userDetailsService;
	//Authentication
	@Autowired
	private PasswordEncoder pwdEncoder;
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
	   //here it automatically calls loadUserByUsername function
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(pwdEncoder);
	}
	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	           .cors().and().csrf().disable()
	            .authorizeHttpRequests()
	                // Allow POST requests to /register/
	                .requestMatchers(HttpMethod.POST, "/register").permitAll()
	                // Allow access to root and other paths as needed
	                .requestMatchers(HttpMethod.GET, "/").permitAll()
	                .anyRequest().authenticated()
	           
	            .and()
	            .formLogin();  // Enable form-based authentication

	        return http.build();
	    }

}
