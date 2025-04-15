package com.ust.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	//Authentication begins
	
	
	@Override
	public void configure (AuthenticationManagerBuilder auth) throws Exception
	{
		auth.inMemoryAuthentication()
		.withUser("nbn")
		.password("nbn221b")
		.roles("user")
		.and()
		.withUser("neeraj")
		.password("neeraj123")
		.roles("admin")
		.and()
		.withUser("test")
		.password("test")
		.roles("testUser");
	
	}
	
	@Bean //For Password Encoding
	public PasswordEncoder getPasswordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}
	
	//Authentication ends
	
	//Authorization begins
	
	@Override
	public void configure(HttpSecurity http) throws Exception
	{
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/api/v1/admin").hasRole("admin")
		.antMatchers("/api/v2/admin").hasRole("admin")
		.antMatchers("/api/v1/policies").hasRole("testUser")
		.antMatchers("/api/v1/**").hasAnyRole("user","admin")
		.antMatchers("/api/v2/**").hasAnyRole("user","admin")
		.antMatchers("/").permitAll()
		.and().formLogin();
		
	}
	
	

}
