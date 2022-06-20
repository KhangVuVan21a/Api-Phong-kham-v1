package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.TimeWork;
@Repository
public interface TimeWorkRepository extends JpaRepository<TimeWork, Integer> {

}
