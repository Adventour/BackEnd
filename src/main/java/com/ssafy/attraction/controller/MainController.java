package com.ssafy.attraction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String index() {
		System.out.println("?");
		return "index";
	}
	
	@GetMapping("/location")
	public String location() {
		System.out.println("!");
		return "location";
	}
}
