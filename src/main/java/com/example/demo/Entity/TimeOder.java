package com.example.demo.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="Time_Oder")
@Data	
@Getter
@Setter
@NoArgsConstructor
public class TimeOder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name="doctor_id")
	private User doctor;
	@Column(name="time_oder")
	private LocalDateTime time;
	@Column(name="symptom")
	private String symptom;
	@CreatedDate
	@Column(name = "create_at")
	private LocalDate createAt;
	@LastModifiedDate
	@Column(name = "update_at")
	private LocalDate updateAt;
	@OneToOne(mappedBy = "timeOder")
	private Heath heath;
}
