package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Boot03jpaApplicationTests {

	@Autowired
	StudentRepository repo;
	
	Logger log = LoggerFactory.getLogger(getClass());
	
//	@Test
	public void insert() {
//		log.info("repo = {}", repo);
		Student student = new Student();
		student.setId(3);
		student.setName("김갑환");
		student.setScore(88);
		repo.save(student);
	}
	
//	@Test
	public void select() {
		long count = repo.count();
		log.info("count = {}", count);
	}

//	@Test
	public void select2() {
		List<Student> list =repo.findAll();
		 for(Student stu : list) {
			log.info(stu.toString());
		}
	}
	
//	@Test
	public void select3() {
		Optional<Student> result = repo.findById(1L);
		log.info("present = {}", result.isPresent()); //있는지 여부
		log.info("result = {}", result.orElse(null)); //없으면 null 반환
		
		Student result2 = repo.getOne(1L); // FetchType.EAGER 설정이 필요
		log.info("result2 = {}", result2);
	}
	
	
//  @Test
	public void select4() {
		for(Student stu : repo.findAllByOrderByIdAsc()) {
			log.info(stu.toString());
		}
	}
	@Test
	public void select5() {
		for(Student stu : repo.findAllByOrderByIdAsc()) {
			log.info(repo.list().toString());
		}
	}
}





