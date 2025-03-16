package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepository;
@Service
public class UserDetailsServiceImpl  implements UserDetailsService {
	@Autowired
   private UserRepository userRepo;
	@Override
	//while login this method automatically called .....
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepo.findByUserName(username);
		System.out.println(user.getRoles());
		return new MyUserDetails(user);
	}

}
