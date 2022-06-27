package com.example.demo.Entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.utility.nullability.MaybeNull;

@Entity
@Table(name="Heath")
@Getter
@Setter
@NoArgsConstructor
public class Heath {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="title",nullable = false)
	private String title;
	
	@Column(name="detail",nullable = false)
	private String detail;
	
	@OneToOne
	@JoinColumn(name="time_oder_id",referencedColumnName = "id")
	private TimeOder timeOder;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn( name="department_id")
	private Department department;
	
	@CreatedDate
	@Column(name="create_at",nullable = false)
	private LocalDate createAt;
	
	@Column(name="update_at" ,nullable = false)
	private LocalDate updateAt;
}
