package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity//엔티티 설정
public class Student {
	@Id//pk 지정
	private long id;
	@Column(length=30)
	private String name;
	@Column
	private int score;
}

