package com.ust.security.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ust.security.enums.Type;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Policy {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long policyId;
	
	
	private long policyNumber;
	//private String type;
	private int premium;
	private String holderName;
	private String holderAddress;
	private String holderContactNumber;
	private String holderEmail;
	
	@OneToMany(mappedBy="policy", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Claim> claims;
	
	
	@Enumerated(EnumType.STRING)
	private Type type;


	public long getPolicyId() {
		return policyId;
	}


	public void setPolicyId(long policyId) {
		this.policyId = policyId;
	}


	public long getPolicyNumber() {
		return policyNumber;
	}


	public void setPolicyNumber(long policyNumber) {
		this.policyNumber = policyNumber;
	}

	public int getPremium() {
		return premium;
	}


	public void setPremium(int premium) {
		this.premium = premium;
	}


	public String getHolderName() {
		return holderName;
	}


	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}


	public String getHolderAddress() {
		return holderAddress;
	}


	public void setHolderAddress(String holderAddress) {
		this.holderAddress = holderAddress;
	}


	public String getHolderContactNumber() {
		return holderContactNumber;
	}


	public void setHolderContactNumber(String holderContactNumber) {
		this.holderContactNumber = holderContactNumber;
	}


	public String getHolderEmail() {
		return holderEmail;
	}


	public void setHolderEmail(String holderEmail) {
		this.holderEmail = holderEmail;
	}


	public List<Claim> getClaims() {
		return claims;
	}


	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}



	public Type getType() {
		return type;
	}


	public void setType(Type type) {
		this.type = type;
	}


	public Policy(long policyId, long policyNumber, int premium, String holderName, String holderAddress,
			String holderContactNumber, String holderEmail, List<Claim> claims, Type type) {
		super();
		this.policyId = policyId;
		this.policyNumber = policyNumber;
		this.premium = premium;
		this.holderName = holderName;
		this.holderAddress = holderAddress;
		this.holderContactNumber = holderContactNumber;
		this.holderEmail = holderEmail;
		this.claims = claims;
		this.type = type;
	}


	@Override
	public String toString() {
		return "Policy [policyId=" + policyId + ", policyNumber=" + policyNumber + ", premium=" + premium
				+ ", holderName=" + holderName + ", holderAddress=" + holderAddress + ", holderContactNumber="
				+ holderContactNumber + ", holderEmail=" + holderEmail + ", claims=" + claims + ", type=" + type + "]";
	}

	public Policy() {}
	
	

}
