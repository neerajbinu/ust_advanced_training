package com.ust.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.security.entity.Claim;
import com.ust.security.repository.ClaimRepository;

@Service
public class ClaimService {
	
	
	@Autowired
	private ClaimRepository cr;
	
	public Claim fileClaim(Claim claim)
	{
		return cr.save(claim);
	}

	public List<Claim>getAllClaims() {
		// TODO Auto-generated method stub
		return cr.findAll();
	}
	

}
