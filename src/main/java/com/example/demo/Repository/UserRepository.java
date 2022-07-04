package com.example.demo.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	boolean existsByEmail(String email);
	boolean existsByUserName(String userName);
	List<User> findAllByUserName(String userName);
	List<User> findAllByLevel(int level);
	User findUserByUserName(String userName);
	List<User> findAllUserByRole(int role);
	@Query(value="SELECT * FROM user u where full_name like %?1% and role =2", nativeQuery = true)
	List<User> findAllDoctor(String name);
}
