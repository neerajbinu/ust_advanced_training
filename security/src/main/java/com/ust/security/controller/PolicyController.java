package com.ust.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.security.entity.Policy;

import com.ust.security.service.PolicyService;

@RestController
@RequestMapping("/api/v1")
public class PolicyController {
	
	@Autowired
	private PolicyService ps;
	
	@PostMapping("/policies")
	public ResponseEntity<Policy> addPolicy(@RequestBody Policy policy)
	{
		Policy newPolicy=ps.addPolicy(policy)	;
		return new ResponseEntity<>(newPolicy,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/policies/{id}")
	public ResponseEntity<String> deletePolicy(@PathVariable Long id)
	{
		ps.deletePolicy(id);
		return new ResponseEntity<>("Policy deleted",HttpStatus.OK);
		
	}
	
	@GetMapping("/policies")
	public ResponseEntity<List<Policy>> getAllPolicies()
	{
		List<Policy> policyList=ps.getAllPolicies();
		return new ResponseEntity<List<Policy>>(policyList,HttpStatus.OK);
	}
	
	
	@GetMapping("/admin")
	public String adminPage()
	{
		return "You are in the admin page";
	}
	
	
	
	
	

}
