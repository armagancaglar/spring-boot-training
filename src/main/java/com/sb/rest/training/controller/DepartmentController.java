package com.sb.rest.training.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sb.rest.training.entity.CustomDepartment;
import com.sb.rest.training.entity.Department;
import com.sb.rest.training.service.DepartmentService;
import com.sb.rest.training.service.PersonnelService;


@RestController
@RequestMapping("department")
public class DepartmentController {
    Logger logger = LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	DepartmentService departmentService;
	@Autowired
	PersonnelService personnelService;
	
	//Create department
	@RequestMapping(path="/create/{departmentName}",method=RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public ResponseEntity<?> createDepartment(@PathVariable("departmentName") String departmentName) {
		Department deptExist = departmentService.findByName(departmentName);
		if(deptExist != null) {
			logger.debug("Department is already exist");
			return new ResponseEntity<>("Department is already exist", HttpStatus.NOT_ACCEPTABLE);
		}
		
		Department dept = new Department();
		dept.setName(departmentName);
		departmentService.save(dept);
		logger.debug(dept.getName() + " is created");
		return new ResponseEntity<>("Department created", HttpStatus.CREATED);	
	}
	
	//Get department
	@RequestMapping(path="/get/{departmentId}",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getDepartment(@PathVariable("departmentId") long departmentId) {
		List<Object> asd = departmentService.getIdAndName(departmentId);
		CustomDepartment cd = (CustomDepartment) asd.get(0);
		logger.debug("getDepartment is called");
		return new ResponseEntity<>(cd, HttpStatus.OK);		
	}	
	
	//Get deparments with personnels
	@RequestMapping(path="/get-all/{page}/{size}",method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<?> getDepartmentAndPersonnel(@PathVariable("page") int page, @PathVariable("size") int size) {
	    @SuppressWarnings("deprecation")
		Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC, "id"));
	    
		Page<Department> dept = departmentService.findAll(PageRequest.of(page, size, sort));
		if(dept != null) {
			logger.debug("getDepartmentAndPersonel is called");
			return new ResponseEntity<>(dept.getContent(), HttpStatus.OK);
		}
		logger.debug("getDepartmentAndPersonel is called department not found");
		return new ResponseEntity<>("Department not found", HttpStatus.NOT_FOUND);	
	}

}
