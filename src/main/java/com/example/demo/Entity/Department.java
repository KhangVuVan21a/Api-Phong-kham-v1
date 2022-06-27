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

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="Department")
@Getter
@Setter
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="title")
	private String title;
	@Column(name="detail")
	private String detail;
	@OneToMany(mappedBy = "department")
	private List<User> doctor;
	@OneToMany( mappedBy = "department")
	private List<Heath> heath;
	
}
