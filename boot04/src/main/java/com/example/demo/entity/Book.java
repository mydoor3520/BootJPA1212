package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor @Builder
@Entity
@SequenceGenerator(
		name="book_seq", 
		sequenceName="book_seq", 
		initialValue=1, 
		allocationSize=1
		)
public class Book {
	
	@Id
	@GeneratedValue(generator="book_seq", strategy=GenerationType.AUTO)
	private long no;
	
	@Column
	@NotNull
	private String name;
	
	@Column
	@NotNull
	private int price;
	
	@CreationTimestamp//등록시간
	private Date reg;
	
	@UpdateTimestamp//수정시간
	private Date fix;
	
}












