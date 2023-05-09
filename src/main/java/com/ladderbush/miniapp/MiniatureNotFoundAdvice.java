package com.ladderbush.miniapp;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class MiniatureNotFoundAdvice {

	@ResponseBody
	@ExceptionHandler(MiniatureNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String MiniatureNotFoundHandler(MiniatureNotFoundException ex) {
		return ex.getMessage();
	}
}