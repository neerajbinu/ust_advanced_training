package com.ust.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.security.entity.Policy;
import com.ust.security.repository.PolicyRepository;

@Service
public class PolicyService {
	
	@Autowired
	private PolicyRepository pr;
	
	
	public Policy addPolicy (Policy policy)
	{
		return pr.save(policy);
	}


	public void deletePolicy(Long id) {
		pr.deleteById(id);
		
	}
	
	
	public List<Policy> getAllPolicies()
	{
		return pr.findAll();
	}

}
