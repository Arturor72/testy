package com.styloop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.styloop.common.util.TestYUtil;
import com.styloop.model.Usuario;
import com.styloop.service.UsuarioService;

@RestController
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@CrossOrigin
	@RequestMapping(value="/login", method=RequestMethod.POST, produces="application/json",consumes="application/json")
	public String login(@RequestBody String usuarioRequest) throws Exception{
		ObjectMapper mapper=new ObjectMapper();
		JsonNode jnode=mapper.readTree(usuarioRequest);
		String username=jnode.get("user").asText();
		String password=jnode.get("password").asText();
		String userAsJson="";
		userAsJson=TestYUtil.convertToJson(usuarioService.getUsuarioByUserAndPassword(username, password));
		return userAsJson;
	}
	@RequestMapping(value="/register", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public void register(@RequestBody Usuario usuario) throws Exception{
		usuarioService.insertUsuario(usuario);
	}
	
}
