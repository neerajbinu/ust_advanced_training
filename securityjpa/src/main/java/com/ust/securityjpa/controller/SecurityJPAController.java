package com.ust.securityjpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityJPAController {
	
	@GetMapping ("/")
	public String home()
	{
		return "You are in the home page";
	}
	@GetMapping ("/user")
	public String user()
	{
		return "You are in the user page";
	}
	@GetMapping ("/admin")
	public String admin()
	{
		return "You are in the admin page";
	}
	

}
