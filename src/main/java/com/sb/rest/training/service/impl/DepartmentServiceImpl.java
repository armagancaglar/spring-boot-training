package com.sb.rest.training.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sb.rest.training.entity.Department;
import com.sb.rest.training.repository.DepartmentRepository;
import com.sb.rest.training.service.DepartmentService;

@Service("DepartmentService")
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public Department save(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public Department findById(long id) {
		// TODO Auto-generated method stub
		return departmentRepository.findById(id);
	}

	@Override
	public Department findByName(String name) {
		// TODO Auto-generated method stub
		return departmentRepository.findByName(name);
	}

	@Override
	public List<Object> getIdAndName(long id) {
		// TODO Auto-generated method stub
		return departmentRepository.getIdAndName(id);
	}

	@Override
	public Department someDept(long id) {
		// TODO Auto-generated method stub
		Department dept = departmentRepository.findById(id);
		dept.setPersonnels(Collections.EMPTY_LIST);
		return dept;
	}

	@Override
	public Page<Department> findAll(Pageable pageable) {
		return departmentRepository.findAll(pageable);
	}

}
