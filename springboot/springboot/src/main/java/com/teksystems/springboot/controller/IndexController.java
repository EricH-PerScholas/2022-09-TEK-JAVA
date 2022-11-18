package com.teksystems.springboot.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.teksystems.springboot.database.dao.CourseDAO;
import com.teksystems.springboot.database.entity.Course;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {

	@Autowired
	private CourseDAO courseDao;

	@Value("${spring.datasource.url}")
	private String variable;

	// search by instructor name
	// add an additional search field to the jsp page to take in the instructor
	// name. Put it in the same form that already exists and give the input box a
	// different name
	// create a DAO method to search by instructor name. Maybe do something fancy to
	// allow finding any string in the instruct name value .. using one of the
	// spring data functions.
	// to the controller .. add another parameter that will take in the insturctor
	// name
	// add the instructor name to the model so you can display again on the page
	// after submit
	// query your list of courses and display them below.
	// BONUS : make a single query that can search by course name or instructor
	// name.

	@RequestMapping(value = { "/", "/index", "/index.html" }, method = RequestMethod.GET)
	public ModelAndView slash(@RequestParam(required = false) String courseName,
			@RequestParam(required = false) String instructorName) {

		ModelAndView response = new ModelAndView();
		response.setViewName("index");

		response.addObject("name", "Eric");

		// print out the incoming value in search variable
		System.out.println("Search parameter to page courseName     : " + courseName);
		System.out.println("Search parameter to page instructorName : " + instructorName);
		// add the search variable to the model so it can be displayed on the page.
		response.addObject("courseNameKey", courseName);
		response.addObject("instructorNameKey", instructorName);

		// if ( courseName != null && !courseName.equals("") ) {
		// List<Course> courses =
		// courseDao.findByNameContainingIgnoreCaseOrderByNameDesc(courseName);
		List<Course> courses = courseDao.findByNameOrInstructor(courseName, instructorName);
		for (Course c : courses) {
			System.out.println(c.getName());
		}
		response.addObject("courses", courses);
		// }

		return response;
	}

	@RequestMapping(value = { "/search" }, method = RequestMethod.GET)
	public ModelAndView search() {
		System.out.println("Index controller search request");

		return null;
	}

	@RequestMapping(value = { "/course" }, method = RequestMethod.GET)
	public ModelAndView course() {
		// this method is called when /course is in the URL
		log.info("Index controller course request method");

		ModelAndView response = new ModelAndView();
		response.setViewName("course");

		return response;
	}

	@RequestMapping(value = { "/courseSubmit" }, method = RequestMethod.GET)
	public ModelAndView courseSubmit(@RequestParam(required = false) String courseName,
			@RequestParam(required = false) String instructorName) {

		ModelAndView response = new ModelAndView();
		response.setViewName("course");

		log.info("Index controller course submit method");
		log.info("Course Submit : courseName     : " + courseName);
		log.info("Course Submit : instructorName : " + instructorName);

		String errormessage = "";
		boolean error = false;
		if (courseName == null || courseName.equals("")) {
			errormessage = errormessage + "The course name can not be empty";
			error = true;
		}

		if (instructorName == null || instructorName.equals("")) {
			errormessage = errormessage + "The instructor name can not be empty";
			error = true;
		}

		if (error) {
			// there is an error
			log.info(errormessage);
			response.addObject("error", errormessage);
		} else {
			Course course = new Course();
			course.setName(courseName);
			course.setInstructor(instructorName);

			courseDao.save(course);
		}
		
		return response;
	}

}
