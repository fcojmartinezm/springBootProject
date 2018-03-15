package com.privalia.repositories;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.privalia.domain.Student;

@RepositoryRestResource
public interface StudentRepository extends CrudRepository<Student, Integer>{
	List<Student> findByName(String name);

}
