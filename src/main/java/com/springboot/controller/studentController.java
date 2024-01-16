package com.springboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Student;
import com.springboot.repository.studentRepository;

@RestController
@RequestMapping("api/")
public class studentController {
	
	@Autowired
	studentRepository studentrepository;
	
	@PostMapping("/student")
	public String createNewStudent(@RequestBody Student student) {
		studentrepository.save(student);
		return "Student created in database";
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudent(){
		List<Student> studList = new ArrayList<>();
		studentrepository.findAll().forEach(studList::add);
		return new ResponseEntity<List<Student>>(studList,HttpStatus.OK);	
	}
	
	@GetMapping("/studentById/{s_id}")
	public ResponseEntity<Student> getstudentbyId(@PathVariable int s_id){
		Optional<Student> stud = studentrepository.findById(s_id);
		if(stud.isPresent()) {
			return new ResponseEntity<>(stud.get(),HttpStatus.FOUND);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/student/{s_name}")
	public ResponseEntity<Student> getstudentbyId(@PathVariable String s_name){
		Optional<Student> stud = studentrepository.findByName(s_name);
		if(stud.isPresent()) {
			return new ResponseEntity<>(stud.get(),HttpStatus.FOUND);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	
	@PutMapping("/student/{s_id}")
	public String UpdateStudentById(@PathVariable int s_id, @RequestBody Student student) {
		
		Optional<Student> stud = studentrepository.findById(s_id);
		if(stud.isPresent()) {
			Student existStud = stud.get();
			existStud.setS_age(student.getS_age());
			existStud.setS_name(student.getS_name());
			existStud.setS_grade(student.getS_grade());
			existStud.setS_address(student.getS_address());
			studentrepository.save(existStud);
			return "Student Details against Id " + s_id + "updated";
		}else {
			return "Student Details does not exist for s_id "+ s_id;		}
	}
	
	@DeleteMapping("/student/{s_id}")
	public String deleteStudentByStudId(@PathVariable int s_id) {
		studentrepository.deleteById(s_id);
		return "Student Data Deleted Successfully";
	}
	
	@DeleteMapping("/student")
	public String deleteAllStudnet() {
		studentrepository.deleteAll();
		return "Student deleted Successfully..";
	}

}


