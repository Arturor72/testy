package com.styloop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import com.styloop.model.Usuario;
import com.styloop.service.UsuarioService;

@Controller
public class TestController {
	@Autowired
	UsuarioService service;
	
	@RequestMapping(method=RequestMethod.GET, value="/arturo", produces="application/json")
	public @ResponseBody String getAlumno() throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new Hibernate4Module());
		
		Usuario usuario=service.getUsuario(1);
		String user=mapper.writeValueAsString(usuario);
		return user;
	}

}
       