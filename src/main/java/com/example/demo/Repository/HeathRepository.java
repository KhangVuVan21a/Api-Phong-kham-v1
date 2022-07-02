package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Dto.HeathDto;
import com.example.demo.Entity.Heath;
import com.example.demo.Entity.User;
@Repository
public interface HeathRepository extends JpaRepository<Heath, Integer>{
	List<HeathDto> getAllHeathByUser(User user);
}
