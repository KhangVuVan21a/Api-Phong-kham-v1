package com.example.demo.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Role;
import com.example.demo.Repository.RoleRepository;
import com.example.demo.Service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public int getRoleIdByName(String roleName) {
		Role role=this.roleRepository.findRoleByName(roleName);
		if(role!=null) {
			return role.getId();
		}
		return 0;
	}
	
	
}
