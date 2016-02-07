package com.styloop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.styloop.common.TestYException;
import com.styloop.common.util.TestYUtil;
import com.styloop.model.Curso;
import com.styloop.service.CursoService;

@RestController
@RequestMapping(value="/curso")
public class CursoController {
	
	@Autowired
	CursoService cursoService;
	@RequestMapping(value="/get", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public String getCurso(@RequestBody String cursoAsString) throws TestYException{
		Curso curso=null;
		String cursoAsJson="";
		try {
			ObjectMapper mapper=new ObjectMapper();
			JsonNode jnode=mapper.readTree(cursoAsString);	
			String cursoId=jnode.get("cur_id").asText();
			curso=cursoService.getCursoById(Integer.parseInt(cursoId));
			cursoAsJson=TestYUtil.convertToJson(curso);
		} catch (Exception e) {
			throw new TestYException();
		}
		
		return cursoAsJson;
	}

}
