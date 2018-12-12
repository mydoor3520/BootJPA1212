package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	//기본적으로 제공되는 기능이 아닌 다른 기능을 만들고 싶으면 이곳에 메소드로 추가
	//메소드 이름 작성시 규칙이 존재
	//http://arahansa.github.io/docs_spring/jpa.html
	
	//아이디를 이용하여 목록 검색		findById	(기본 제공)
	//이름을 이용하여 목록 검색		findByName	(직접 구현)
	//점수를 이용하여 목록 검색		findByScore	(직접 구현)
	
	List<Student> findByName(String name);
	List<Student> findByScore(int score);
	List<Student> findByNameAndScore(String name, int score);
	
	//아이디 순서로 검색하기 위한 메소드
	List<Student> findAllByOrderByIdAsc();
	//이름순
	List<Student> findAllByOrderByNameAsc();
	//이름을 검색하여 아이디순
	List<Student> findByNameOrderByIdAsc(String name);
	
	//이름만 가지고 만들 수 없는 복잡한 구문은 직접 구현	@Query
	//[1] JPQL을 이용
	@Query(value="select s from Student s")
	List<Student> list();
	
	//[2] Native Query 이용
	@Query(nativeQuery=true,value="select * from Student")
	List<Student> list2();
}


