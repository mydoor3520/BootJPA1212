package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	@ResponseBody
	public String hello() {
		return "hello";
	}
	
	@RequestMapping("/json")
	@ResponseBody
	public List<String> json(){
		return List.of("java", "c", "phyton", "android", "bigdata");
	}
}
