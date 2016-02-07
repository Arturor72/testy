package com.styloop.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.styloop.common.TestYError;
import com.styloop.common.TestYException;
import com.styloop.common.util.TestYUtil;

@RestController
@ControllerAdvice
public class AdviseController {
	
	@ExceptionHandler(TestYException.class)
	public String responseError(TestYException exception) throws Exception{
		TestYError error=new TestYError();
		error.setErroCode(exception.getErrorCode());
		error.setErrorMessage(exception.getErrorMessage());
		String erroAsJson=TestYUtil.convertToJson(error);
		return erroAsJson;
	}

}
