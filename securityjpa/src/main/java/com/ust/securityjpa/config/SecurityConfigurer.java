package com.ust.securityjpa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ust.securityjpa.service.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private MyUserDetailsService muds;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)throws Exception
	{	
		    auth.inMemoryAuthentication()
		        .withUser("user").password(passwordEncoder().encode("user123")).roles("USER")
		        .and()
		        .withUser("admin").password(passwordEncoder().encode("admin123")).roles("ADMIN");
		

		auth.userDetailsService(muds).passwordEncoder(passwordEncoder());
		
		//auth.userDetailsService(muds).passwordEncoder(passwordEncoder());
	}
	
	
	
	@Override
	protected void configure (HttpSecurity http) throws Exception
	{
		http.authorizeRequests()
		.antMatchers("/admin").hasRole("admin")
		.antMatchers("/user").hasAnyRole("admin","user")
		.antMatchers("/").permitAll()
		.and().formLogin().and()
		.httpBasic();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	

}








//@Override
//protected void configure (HttpSecurity http)throws Exception
//{
//	http.authorizeRequests()
//	.antMatchers("/admin").hasRole("admin")
//	.antMatchers("/user").hasRole("admin","user")
//	.antMatchers("/".permitAll()
//	.and().formLogin();	
//}
