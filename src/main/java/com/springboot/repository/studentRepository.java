package com.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.springboot.entity.Student;

public interface studentRepository extends JpaRepository<Student, Integer>{

	
	@Query("SELECT c FROM Student c WHERE c.s_name = :s_name")
	Optional<Student> findByName(@Param("s_name") String s_name);

}
