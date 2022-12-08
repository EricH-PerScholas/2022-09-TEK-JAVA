package com.teksystems.springboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.teksystems.springboot.database.dao.CourseDAO;
import com.teksystems.springboot.database.entity.Course;
import com.teksystems.springboot.database.entity.UserRole;
import com.teksystems.springboot.form.CourseFormBean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CourseController {
	
	@Autowired
	private CourseDAO courseDao;

	@RequestMapping(value = { "/course/create" }, method = RequestMethod.GET)
	public ModelAndView course() {
		ModelAndView response = new ModelAndView();
		response.setViewName("course/coursecreate");

		return response;
	}
	
	@RequestMapping(value = "/course/save", method = RequestMethod.POST)
	public ModelAndView createUserSubmit(@Valid CourseFormBean form, BindingResult bindingResult) {
		ModelAndView response = new ModelAndView();
		
		// after the course is saved then it will rediret to the search page and pass the courseName
		// so that the ssearch will show the result set including the course we just edited
		response.setViewName("redirect:/index?courseName=" + form.getCourseName());
		

		for (ObjectError e : bindingResult.getAllErrors()) {
			log.debug(e.getObjectName() + " : " + e.getDefaultMessage());
		}

		if (!bindingResult.hasErrors()) {
			Course course = courseDao.findById(form.getId());
			if ( course == null ) {
				course = new Course();
			}

			course.setInstructor(form.getInstructor());
			course.setName(form.getCourseName());

			courseDao.save(course);

		} else {
			response.addObject("bindingResult", bindingResult);
			response.addObject("form", form);
		}

		return response;
	}
	
	@RequestMapping(value = { "/course/edit" }, method = RequestMethod.GET)
	public ModelAndView courseEdit(@RequestParam(required = true) Integer id) {
		ModelAndView response = new ModelAndView();
		
		response.setViewName("course/coursecreate");
		
		Course c = courseDao.findById(id);
		
		CourseFormBean form = new CourseFormBean();
		
		form.setId(c.getId());
		form.setCourseName(c.getName());
		form.setInstructor(c.getInstructor());
		
		response.addObject("form", form);

		return response;
	}

	
}
