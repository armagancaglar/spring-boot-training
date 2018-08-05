package com.sb.rest.training.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.sb.rest.training.entity.Department;
import com.sb.rest.training.entity.Personnel;
import com.sb.rest.training.service.DepartmentService;
import com.sb.rest.training.service.PersonnelService;

@RestController
@RequestMapping("personnel")
public class PersonnelController {
    Logger logger = LoggerFactory.getLogger(PersonnelController.class);

	@Autowired
	PersonnelService personnelService;
	@Autowired
	DepartmentService departmentService;
	
//	@Bean
//	public FilterRegistrationBean filterRegistrationBean() {
//	    FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//	    CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
//	    characterEncodingFilter.setForceEncoding(true);
//	    characterEncodingFilter.setEncoding("UTF-8");
//	    registrationBean.setFilter(characterEncodingFilter);
//	    return registrationBean;
//	}
    
	//Create personnel
	@RequestMapping(path="/create/{personnelName}/{departmentId}",method=RequestMethod.POST)
	public ResponseEntity<?> createPersonnel(@PathVariable("personnelName") String personnelName,@PathVariable("departmentId") long departmentId) throws UnsupportedEncodingException {
		personnelName = URLDecoder.decode(personnelName, "UTF-8");

		Department dept = new Department();
		dept = departmentService.findById(departmentId);
		Personnel personnelExist = personnelService.findByName(personnelName);
		if(personnelExist != null) {
			logger.debug(personnelName + " is already exist");
			return new ResponseEntity<>("Personnel is already exist", HttpStatus.NOT_ACCEPTABLE);	
		}
		Personnel person = new Personnel();
		person.setDepartment(dept);
		person.setName(personnelName);
		logger.debug(personnelName + " is created");
		return new ResponseEntity<>(personnelService.save(person), HttpStatus.CREATED);
	}
	
	
	//Get personnel
	@RequestMapping(path="/get/{personnelId}",method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<?> getPersonnel(@PathVariable("personnelId") long personnelId) {
		Personnel personnel = personnelService.findById(personnelId);
		if(personnel != null) {
			logger.debug(personnel.getName() + " is returned");
			return new ResponseEntity<>(personnel, HttpStatus.OK);	
		}
		logger.debug(personnelId + " is not found");
		return new ResponseEntity<>("Personnel Not Found", HttpStatus.NOT_FOUND);
	}
}
