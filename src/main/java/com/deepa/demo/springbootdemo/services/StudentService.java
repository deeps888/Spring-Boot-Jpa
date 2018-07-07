package com.deepa.demo.springbootdemo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deepa.demo.springbootdemo.model.Student;
import com.deepa.demo.springbootdemo.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Student add(Student student) {
		return studentRepository.saveAndFlush(student);
	}

	public Student get(String id) {

		Optional<Student> student = studentRepository.findById(id);

		return student.isPresent() ? student.get() : null;
	}
}
