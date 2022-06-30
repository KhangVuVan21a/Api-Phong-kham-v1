package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

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
//	@Query("SELECT u FROM User WHERE u.userName = ?1")
//	User findUserByName(String userName);
}
