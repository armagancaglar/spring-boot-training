package com.sb.rest.training.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sb.rest.training.entity.Department;

@Repository("departmentRepository")
public interface DepartmentRepository extends JpaRepository<Department, Long>{
	Department findById(long id);
	Department findByName(String name);
	@Query("select new com.sb.rest.training.entity.CustomDepartment(d.id, d.name) from Department d where d.id = :id")
	List<Object> getIdAndName(@Param("id") long id);
	Page<Department> findAll(Pageable pageable);
}
