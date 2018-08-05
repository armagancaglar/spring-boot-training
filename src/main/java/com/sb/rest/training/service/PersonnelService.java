package com.sb.rest.training.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sb.rest.training.entity.Personnel;


public interface PersonnelService {
	Personnel save(Personnel personnel);
	public Personnel findById(long id);
	public Personnel findByName(String name);
	public List<Personnel> findByDepartmentId(long id);

}
