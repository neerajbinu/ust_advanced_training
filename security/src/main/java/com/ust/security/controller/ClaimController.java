package com.ust.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.security.entity.Claim;
import com.ust.security.service.ClaimService;

@RestController
@RequestMapping("/api/v2")
public class ClaimController {
	
	
	@Autowired
	private ClaimService cs; 
	
	@PostMapping("/claims")
	public ResponseEntity<Claim>fileClaim(@RequestBody Claim claim)
	{
		Claim filedClaim=cs.fileClaim(claim);
		return new ResponseEntity<>(filedClaim,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/claims")
	public ResponseEntity<List<Claim>>getAllClaims()
	{
		List<Claim>claimsList=cs.getAllClaims();
		return new ResponseEntity<>(claimsList,HttpStatus.OK);
		
	}	
	
	@GetMapping("/admin")
	public String adminPage()
	{
		return "You are in the admin page";
	}

}
