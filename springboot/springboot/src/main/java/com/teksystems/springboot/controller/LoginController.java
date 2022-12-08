package com.teksystems.springboot.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.teksystems.springboot.database.dao.UserDAO;
import com.teksystems.springboot.database.dao.UserRoleDAO;
import com.teksystems.springboot.database.entity.User;
import com.teksystems.springboot.database.entity.UserRole;
import com.teksystems.springboot.form.CreateUserForm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {

	@Autowired
	private UserDAO userDao;

	@Autowired
	private UserRoleDAO userRoleDao;

	@Autowired
	@Qualifier("passwordEncoder")
	private PasswordEncoder passwordEncoder;

	// this method is request mapping to show the actual login JSP page.
	// the URL here in the mapping is the same URL configured in spring security
	// .loginPage
	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView response = new ModelAndView();
		response.setViewName("login_pages/login");
		return response;
	}

	// in this situation we are returning the view name as a string without a model
	@RequestMapping(value = "/user/example", method = RequestMethod.GET)
	public String example() {
		// so if the method returns just a string then that is considered to be the view
		// name
		return "login_pages/login";

		// this is not to be confused with the @ResponseBody annotation, which would
		// then return the string
		// directely to the browser with no view
	}

	@RequestMapping(value = "/user/createuser", method = RequestMethod.GET)
	public ModelAndView createUser() {
		ModelAndView response = new ModelAndView();
		response.setViewName("login_pages/create_user");

		log.debug("This is in the GET method for create user");
		return response;
	}

	@RequestMapping(value = "/user/createuser", method = RequestMethod.POST)
	public ModelAndView createUserSubmit(@Valid CreateUserForm form, BindingResult bindingResult) {
		ModelAndView response = new ModelAndView();
		response.setViewName("login_pages/create_user");
		log.debug("This is in the POST method for create user");

		log.debug(form.toString());

		for (ObjectError e : bindingResult.getAllErrors()) {
			log.debug(e.getObjectName() + " : " + e.getDefaultMessage());
		}

		if (!bindingResult.hasErrors()) {
			User user = userDao.findById(form.getId());
			if ( user == null ) {
				user = new User();
			}

			String encodedPassword = passwordEncoder.encode(form.getPassword());
			user.setPassword(encodedPassword);

			user.setFirstName(form.getFirstName());
			user.setLastName(form.getLastName());
			user.setEmail(form.getEmail());
			user.setAddress(form.getAddress());
			user.setCity(form.getCity());
			user.setState(form.getState());
			user.setZip(form.getZip());
			user.setPhone(form.getPhone());
			user.setCreateDate(new Date());
			user.setAvatar(form.getAvatar());

			userDao.save(user);

			UserRole ur = new UserRole();
			ur.setRoleName("USER");
			ur.setUserId(user.getId());

			userRoleDao.save(ur);

		} else {
			response.addObject("bindingResult", bindingResult);
			response.addObject("form", form);
		}

		return response;
	}

	@RequestMapping(value = "/user/edituser", method = RequestMethod.GET)
	public ModelAndView editUser(@RequestParam Integer id) {
		// incoming id is the id of the user we want to edit
		ModelAndView response = new ModelAndView();
		response.setViewName("login_pages/create_user");

		User user = userDao.findById(id);

		CreateUserForm form = new CreateUserForm();

		// we are setting this on the form, so that it can be built into the hidden variable on the page
		// so that .. it gets submitted to the save method so that .. it can load the user object before
		// writing data to it.
		form.setId(user.getId());
		
		
		form.setFirstName(user.getFirstName());
		form.setLastName(user.getLastName());
		form.setEmail(user.getEmail());
		form.setAddress(user.getAddress());
		form.setCity(user.getCity());
		form.setState(user.getState());
		form.setZip(user.getZip());
		form.setPhone(user.getPhone());
		form.setAvatar(user.getAvatar());
		
		response.addObject("form",form);

		log.debug("This is in the GET method for edit user user");
		return response;
	}
}
