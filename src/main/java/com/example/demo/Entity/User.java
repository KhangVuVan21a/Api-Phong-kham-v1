package com.example.demo.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "User")
@Getter
@Setter
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="username",nullable = false)
	private String userName;
	@Column(name="password",nullable = false)
	private String password;
	@Column(name="full_name")
	private String fullName;
	@Column(name="birthday")
	private LocalDate birth;
	@Column(name="sex")
	private boolean sex;
	@Column(name="email")
	private String email;
	@Column(name="address")
	private String address;
	@Column(name="phone_number")
	private String phoneNumber;
	@CreatedDate
	@Column(name="create_at")
	private LocalDateTime createAt;
	@LastModifiedDate
	@Column(name="update_at")
	private LocalDateTime updateAt;
	@Column(name = "level")
	private int level;
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "user")
	private List<Heath> heath;
	@OneToMany(mappedBy = "user")
	private List<TimeOder> timeOdersUser;
	@OneToMany(mappedBy = "doctor")
	private List<TimeOder> timeOdersDoctor;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="department_id")
	private Department department;
	@OneToMany( mappedBy = "doctor")
	private List<TimeWork> timeWorks;
}
