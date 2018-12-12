package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Boot04sequenceApplicationTests {

	@Autowired
	BookRepository repo;
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	@Test
	public void test() throws InterruptedException {
		Book book = Book.builder().name("어린왕자").price(5000).build();
		Book insert = repo.save(book);//등록
		log.info("insert = {}", insert);
		
		long count = repo.count();
		log.info("count = {}", count);
		
		Thread.sleep(5000L);
		insert.setName("키다리아저씨");
		insert.setPrice(9900);
		repo.save(insert);//수정
	}

}








