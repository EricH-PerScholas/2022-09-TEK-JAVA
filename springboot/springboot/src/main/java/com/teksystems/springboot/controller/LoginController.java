package com.teksystems.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.teksystems.springboot.database.dao.UserDAO;
import com.teksystems.springboot.database.entity.User;
import com.teksystems.springboot.form.CreateUserForm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {
	
	@Autowired
	private UserDAO userDao;
	
	
	@RequestMapping(value = "/user/createuser" , method = RequestMethod.GET)
	public ModelAndView createUser(CreateUserForm form) {
		ModelAndView response = new ModelAndView();
		response.setViewName("login_pages/create_user");
		
		log.debug(form.toString());
		
		User user = new User();
		
		user.setFirstName(form.getFirstName());
		user.setLastName(form.getLastName());
		user.setEmail(form.getEmail());
		user.setPassword(form.getPassword());
		user.setAddress(form.getAddress());
		user.setCity(form.getCity());
		user.setState(form.getState());
		user.setZip(form.getZip());
		user.setPhone(form.getPhone());
		
		//userDao.save(user);
		
		return response;
	}
}
