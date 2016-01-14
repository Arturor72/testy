package com.styloop.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.styloop.common.TestYException;
import com.styloop.common.util.TestYUtil;

@RestController
public class AdviseController {
	
	@ExceptionHandler(TestYException.class)
	public String responseError(TestYException exception) throws Exception{
		String erroAsJson=TestYUtil.convertToJson(exception);
		return erroAsJson;
	}

}
