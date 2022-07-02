package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.TimeOder;
import com.example.demo.Entity.User;
@Repository
public interface TimeOderRepository extends JpaRepository<TimeOder, Integer>{
	List<TimeOder> findAllTimeOderByUser(User user);
	List<TimeOder> findAllTimeOderByDoctor(User doctor);
}
