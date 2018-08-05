package com.sb.rest.training.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.rest.training.entity.Personnel;
import com.sb.rest.training.repository.PersonnelRepository;
import com.sb.rest.training.service.PersonnelService;

@Service("PersonnelService")
public class PersonnelServiceImpl implements PersonnelService {

	@Autowired
	PersonnelRepository personnelRepository;
	
	@Override
	public Personnel save(Personnel personnel) {
		return personnelRepository.save(personnel);
	}

	@Override
	public Personnel findById(long id) {
		return personnelRepository.findById(id);
	}

	@Override
	public Personnel findByName(String name) {
		return personnelRepository.findByName(name);
	}

	@Override
	public List<Personnel> findByDepartmentId(long id) {
		return personnelRepository.findByDepartmentId(id);
	}

}
