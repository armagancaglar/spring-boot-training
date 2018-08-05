package com.sb.rest.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sb.rest.training.entity.Personnel;

@Repository("personnelRepository")
public interface PersonnelRepository extends JpaRepository<Personnel, Long>{

	Personnel findById(long id);
	Personnel findByName(String name);
	List<Personnel> findByDepartmentId(long id);
}
