package com.deepa.demo.springbootdemo.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.deepa.demo.springbootdemo.model.Message;

@ControllerAdvice
public class ExceptionTranslater {

	public ResponseEntity<Message> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {

		StringBuilder description = new StringBuilder("Fields data not found or invalid - ");

		if (!ObjectUtils.isEmpty(ex.getBindingResult())) {
			ex.getBindingResult().getFieldErrors().forEach(v -> description.append(v.getField() + ", "));
			int size = description.length();
			description.delete(size - 2, size);
		}
		Message message = new Message(HttpStatus.BAD_REQUEST.value(), description.toString());

		return new ResponseEntity<Message>(message, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Message> handleException(Exception ex) {

		Message message = new Message(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());

		return new ResponseEntity<Message>(message, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
