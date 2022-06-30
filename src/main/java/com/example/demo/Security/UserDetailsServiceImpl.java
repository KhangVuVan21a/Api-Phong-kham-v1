package com.example.demo.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.Repository.RoleRepository;
import com.example.demo.Repository.UserRepository;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	@Autowired 
	private RoleRepository roleRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user =  this.userRepository.findUserByUserName(username);
		if(user==null) {
			throw new UsernameNotFoundException("User not Found "+username);
		}
		if(user.getRoleUser()==null) {
			user.setRoleUser(this.roleRepository.findRoleById(user.getRole()));
		}
		return UserDetailImpl.build(user);
	}

}
