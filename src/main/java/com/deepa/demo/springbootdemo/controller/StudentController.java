package com.deepa.demo.springbootdemo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deepa.demo.springbootdemo.model.Student;
import com.deepa.demo.springbootdemo.services.StudentService;

@RestController
@RequestMapping("deeps")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping(value = "student", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<String> addUserDetails(@Valid @RequestBody Student student) {

		return new ResponseEntity<String>(studentService.add(student).getId(), HttpStatus.OK);
	}

	@GetMapping(value = "student", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Student> getUserDetails(@RequestHeader("id") String id) {

		Student student = studentService.get(id);
		HttpStatus status = HttpStatus.OK;
		if (ObjectUtils.isEmpty(student))
			status = HttpStatus.NOT_FOUND;
		return new ResponseEntity<Student>(student, status);
	}

}
