package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

	@GetMapping("")
	public String list(@RequestParam int id){
		return "기존방식 : " + id +"번 학생 조회 결과";
	}
	
	@GetMapping("{id}")
	public String find(@PathVariable int id){
		return "신규방식 : " + id +"번 학생 조회 결과";
	}
	

}
