package com.example.demo.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/test")
	public String test1() {
		return "hello / select";
	}
	
	@PostMapping("/test")
	public String test2() {
		return "등록완료 / insert";
	}
	
	@PutMapping("/test")
	public String test3() {
		return "수정완료 / update";
	}
	
	@DeleteMapping("/test")
	public String test4() {
		return "삭제완료 / delete";
	}
}
