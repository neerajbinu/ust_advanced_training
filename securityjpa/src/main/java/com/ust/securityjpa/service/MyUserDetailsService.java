package com.ust.securityjpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ust.securityjpa.entity.MyUser;
import com.ust.securityjpa.repository.MyUserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private MyUserRepository mur;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<MyUser> myOptionalUser=mur.findByUsername(username);
		if(!myOptionalUser.isPresent())
		{
			throw new UsernameNotFoundException("User not found");
		}
		
		MyUser myUser=myOptionalUser.get();
		
		List<SimpleGrantedAuthority> authorities=new ArrayList<>();
		String[] roles= myUser.getRoles().split(",");
		
		for(String role:roles)
		{
			authorities.add(new SimpleGrantedAuthority(role.trim()));
		}
		
		return new org.springframework.security.core.userdetails.User(myUser.getUsername(),myUser.getPassword(),authorities);
			
		
	}
	
	
	
	
	
	
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		Optional<MyUser> myOptionalUser=mur.findByUsername(username); 
//		
//		if (!myOptionalUser.isPresent())
//		{
//			throw new UsernameNotFoundException("username not found");
//		}
//		MyUser myUser=myOptionalUser.get();
//		
//		//Create a List of type SimpleGrantedAuthorities
//		List<SimpleGrantedAuthority>authorities=new ArrayList<>();
//		
//		//Split the roles
//		String[] roles=myUser.getRoles().split(",");
//		
//		//Add the roles to the list
//		//note - .add(new SimpleGrantedAuthority(role.trim())
//		for(String role:roles)
//		{
//			authorities.add(new SimpleGrantedAuthority(role.trim()));
//		}
//		
//		
//		//Notice the return statement and what all we are returning
//		return new org.springframework.security.core.userdetails.User
//				(myUser.getUsername(), myUser.getPassword(), authorities);
//				
//		
//
//	}


	

}
