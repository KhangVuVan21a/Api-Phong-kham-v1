package com.example.demo.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="Department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="title",nullable = false)
	private String title;
	@Column(name="detail",nullable = false)
	private String detail;
	@OneToMany(mappedBy = "department")
	private List<User> doctor;
	@OneToMany( mappedBy = "department")
	private List<Heath> heath;
	
}
