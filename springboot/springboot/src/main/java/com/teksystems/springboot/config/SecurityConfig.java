package com.teksystems.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http
			.csrf().disable()
	        .authorizeRequests()
	        	.antMatchers("/pub/**", "/user/**", "/", "/index").permitAll()
				.anyRequest().authenticated()
	        	.and()
	        .formLogin()
	        	// this is the URL to the login page
	        	// the request method for this is implemented in the login controller
	        	// to display the login.jsp view
	            .loginPage("/user/login")
	            // this is the URL that the login page will submit to with a action="/user/login" method="POST"
	            .loginProcessingUrl("/user/loginpost")
	            .and()
	        .logout()
	            .invalidateHttpSession(true)
	            // this is the URL to log a user out
	            .logoutUrl("/user/logout")
	            // this is the URL to send the browser to after the user has logged out
	            .logoutSuccessUrl("/index");
		

	}
	

	
	// this is boiler plate code that can be copied and pasted into your security configuration
	@Bean(name="passwordEncoder")
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
