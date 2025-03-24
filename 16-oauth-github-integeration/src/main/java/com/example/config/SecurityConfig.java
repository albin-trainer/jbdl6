package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.IdTokenClaimNames;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	  @Bean
	  public ClientRegistrationRepository clientRegistrationRepository () {
		return new InMemoryClientRegistrationRepository(this.clientRegistration());
	    
	}
	
	 private ClientRegistration clientRegistration () {
		 
      return ClientRegistration
    		  .withRegistrationId("mygithub")
    		  .clientId("Ov23lijZwaWYuf2uQYFc")
    		  .clientSecret("1536253e5030554c398448cd05f5573c456cc209")
       .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
       .scope("read")
       .authorizationUri("https://github.com/login/oauth/authorize")
       .tokenUri("https://github.com/login/oauth/access_token")
       .userInfoUri("https://api.github.com/user")
       .userNameAttributeName("id")
       .clientName("mySecurityGitApp")
       .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
       .redirectUri("{baseUrl}/login/oauth2/code/{registrationId}")
       .build();
	
	}
	 
	 @Bean
	 public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception {
		 httpSecurity.oauth2Login(c -> c.getClass());
		 httpSecurity.authorizeHttpRequests(request -> request.anyRequest().authenticated());
		 return httpSecurity.build();
		 
	 }
	
	

}
