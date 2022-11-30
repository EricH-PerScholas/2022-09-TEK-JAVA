package com.teksystems.springboot.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Pattern.Flag;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateUserForm {
	
	@NotEmpty(message = "Email is required.")
	@Length(max = 200, message = "Email must be less than 200 characters.")
	private String email;
	
	@Pattern(regexp = "^[a-zA-Z0-9!@#]+$", message = "Password can only contain lowercase, uppercase, and special caracters")
	@Length(min = 8, message = "Password must be longer than 8 characters.")
	@Length(max = 25, message = "Password must be shorter than 25 characters.")
	private String password;
	
	
	private String confirmPassword;
	
	
	private String firstName;
	private String lastName;
	private String address;
	
	@Length(max = 45, message = "City must be less than 45 characters.")
	private String city;
	
	@Length(max = 45, message = "State must be less than 45 characters.")
	private String state;
	
	@Length(max = 45, message = "Zip code must be less than 45 characters.")
	private String zip;
	
	@Length(max = 45, message = "Phone number must be less than 45 characters.")
	private String phone;
	
	
}
