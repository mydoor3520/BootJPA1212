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
@SequenceGenerator(name="station_seq", sequenceName="station_seq", 
						allocationSize=1, initialValue=1)
public class Station {
	
	@Id @GeneratedValue(generator="station_seq", strategy=GenerationType.AUTO)
	private long no;
	
	@Column(length=60) @NotNull
	private String name;
	
	@Column(length=30) @NotNull
	private String area;
	
	@Column(length=60) @NotNull
	private String line;
	
	@Column
	private Long recommend;
	
	@CreationTimestamp
	private Date reg;
	
	@UpdateTimestamp
	private Date fix;
	
	
}




