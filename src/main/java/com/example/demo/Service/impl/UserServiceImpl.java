package com.example.demo.Service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.Email;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.LoginDto;
import com.example.demo.Dto.RegisterDto;
import com.example.demo.Dto.UserDto;
import com.example.demo.Dto.UserJwtDto;
import com.example.demo.Entity.User;
import com.example.demo.ModelMapper.UserMapper;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.RoleService;
import com.example.demo.Service.UserService;
import com.example.demo.Utils.Constants;
import com.example.demo.common.util.JwtUtil;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

//	@Autowired
//	private MapperDto mapperDto;

	// @Autowired
	private UserMapper userMapper;

    @Autowired
    private RoleService roleService;
//    
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UserDetailsService userdetailsService;


	@Override
	public UserJwtDto userLogin1(LoginDto input) {
		UserDetails userDetails = this.userdetailsService.loadUserByUsername(input.getUserName());

		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				userDetails, input.getPassword(), userDetails.getAuthorities()));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		User userEntity = this.userRepository.findUserByUserName(userDetails.getUsername());

		return this.getUserJwt(authentication, userEntity);
	}

	@Override
	public UserJwtDto userRegister1(RegisterDto input) {
		int roleCustomerId = this.roleService.getRoleIdByName(Constants.ROLE_USER);

		User user = this.userMapper.getInstance().registertoEntity(input);
		user.setRole(roleCustomerId);
		user.setPassword(this.passwordEncoder.encode(input.getPassword()));
		user.setCreateAt(LocalDateTime.now());
		user.setUpdateAt(LocalDateTime.now());
		this.userRepository.save(user);

		return this.userLogin1(input);
	}

	@Override
	public UserDto userLogin(LoginDto input) {
		User user = this.userRepository.findAllByUserName(input.getUserName()).stream().findFirst().orElse(null);
		return this.passwordEncoder.matches(input.getPassword(), user.getPassword())
				? this.userMapper.getInstance().toDto(user)
				: null;
	}

	@Override
	public UserDto userRegister(RegisterDto input) {
		User user = this.userMapper.getInstance().registertoEntity(input);
		user.setUserName(input.getUserName());
		user.setPassword(this.passwordEncoder.encode(input.getPassword()));
		user.setLevel(input.getLevel());
		user.setCreateAt(LocalDateTime.now());
		return this.userMapper.getInstance().toDto(this.userRepository.save(user));
	}

	@Override
	public boolean isCheckEmail(@Email String email) {
		if (Strings.isNotEmpty(email)) {
			return this.userRepository.existsByEmail(email);
		}
		return false;
	}

	@Override
	public boolean isCheckUserName(String userName) {
		if (Strings.isNotEmpty(userName)) {
			return this.userRepository.existsByUserName(userName);
		}
		return false;
	}
	
	 private UserJwtDto getUserJwt(Authentication authentication, User userEntity)
	    {
	        String jwtToken = jwtUtil.generateJwtToken(authentication);
	        String role = userEntity.getRoleUser().getName();

	        return new UserJwtDto(jwtToken, role, this.userMapper.getInstance().toDto(userEntity));
	    }


	@Override
	public UserDto updateUser(UserDto userDto, int idUser) {
		User user = userRepository.findById(idUser).get();
		if (user == null)
			return null;
		user.setEmail(userDto.getEmail());
		user.setAddress(userDto.getAddress());
		user.setBirth(userDto.getBirth());
		user.setFullName(userDto.getFullName());
		user.setSex(userDto.isSex());
		user.setPhoneNumber(userDto.getPhoneNumber());
		user.setUpdateAt(LocalDateTime.now());
		return this.userMapper.getInstance().toDto(userRepository.save(user));
	}

	@Override
	public List<UserDto> getAllUser() {
		List<UserDto> list = new ArrayList<>();
		list = userRepository.findAll().stream().map(i -> this.userMapper.getInstance().toDto(i))
				.collect(Collectors.toList());
		return list;
	}

	@Override
	public UserDto findUserByUserName(String userName) {
		return this.userMapper.getInstance().toDto(userRepository.findAllByUserName(userName).get(0));
	}

	@Override
	public List<UserDto> getAllUserByLevel(int level) {
		return this.getAllUser().stream().filter(i -> i.getLevel() == level).collect(Collectors.toList());
	}

	@Override
	public UserDto getUserById(int id) {
		UserDto userDto = this.userMapper.getInstance().toDto(this.userRepository.findById(id).get());
		return userDto == null ? null : userDto;
	}

}
