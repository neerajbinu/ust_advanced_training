package com.ust.security.entity;

import java.time.LocalDate;

//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.ust.security.enums.Type;

import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Claim {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long claimId;
	
	
	private long claimNumber;
	private LocalDate claimDate;
	private int claimAmount;
	private String description;
	//private String type;
	
	
//	@Enumerated(EnumType.STRING)
//	private Type type;
	
	@ManyToOne()
	@JoinColumn(name="policy_id")
	//@JsonIgnore
	private Policy policy;

	public long getClaimId() {
		return claimId;
	}

	public void setClaimId(long claimId) {
		this.claimId = claimId;
	}

	public long getClaimNumber() {
		return claimNumber;
	}

	public void setClaimNumber(long claimNumber) {
		this.claimNumber = claimNumber;
	}

	public LocalDate getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(LocalDate claimDate) {
		this.claimDate = claimDate;
	}

	public int getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(int claimAmount) {
		this.claimAmount = claimAmount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}
	
	
//	public Type getType() {
//		return type;
//	}
//
//
//	public void setType(Type type) {
//		this.type = type;
//	}

	@Override
	public String toString() {
		return "Claim [claimId=" + claimId + ", claimNumber=" + claimNumber + ", claimDate=" + claimDate
				+ ", claimAmount=" + claimAmount + ", description=" + description + ", policy=" + policy + "]";
	}

	public Claim(long claimId, long claimNumber, LocalDate claimDate, int claimAmount, String description,
			Policy policy) {
		super();
		this.claimId = claimId;
		this.claimNumber = claimNumber;
		this.claimDate = claimDate;
		this.claimAmount = claimAmount;
		this.description = description;
		this.policy = policy;
		//this.type=type;
	}
	
	public Claim() {}
	
	
}
