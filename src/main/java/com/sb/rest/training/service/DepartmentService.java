package com.sb.rest.training.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sb.rest.training.entity.Department;

public interface DepartmentService {

	public Department save(Department department);
	public Department findById(long id);
	public Department findByName(String name);
	public List<Object>  getIdAndName(long id);
	public Department someDept(long id);
	public Page<Department> findAll(Pageable pageable);

}
