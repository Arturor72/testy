package com.styloop.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.styloop.common.TestYConstants;
import com.styloop.common.TestYException;
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
	public String login(@RequestBody String usuarioRequest) throws TestYException{
		String userAsJson="";
		try {
			ObjectMapper mapper=new ObjectMapper();
			JsonNode jnode=mapper.readTree(usuarioRequest);	
			String username=jnode.get("usr_usr").asText();
			String password=jnode.get("usr_pas").asText();
			userAsJson=TestYUtil.convertToJson(usuarioService.getUsuarioByUserAndPassword(username, password));		
		} catch (JsonProcessingException e) {
			throw new TestYException(TestYConstants.ERROR_E01,e.getMessage());
		} catch (IOException e) {
			throw new TestYException(TestYConstants.ERROR_E01,e.getMessage());
		} catch(NullPointerException e){
			throw new TestYException(TestYConstants.ERROR_E01,"parameter not found");
		}
		return userAsJson;
	}
	
	@RequestMapping(value="/verify", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public String getUserByUsername(@RequestBody String usernameRequest){
		String userAsJson="";
		try {
			ObjectMapper mapper=new ObjectMapper();
			JsonNode jnode=mapper.readTree(usernameRequest);	
			String username=null;
			String usermail=null;
			if(jnode.get("usr_usr")!=null){
				username=jnode.get("usr_usr").asText();	
			}else if(jnode.get("usr_ema")!=null){
				usermail=jnode.get("usr_ema").asText();	
			}
			userAsJson=TestYUtil.convertToJson(usuarioService.getUsuario(username,usermail));
			System.out.println(userAsJson);
			if(userAsJson==null){
				userAsJson="{\"result\":0}";
			}
			
		} catch (JsonProcessingException e) {
			throw new TestYException(TestYConstants.ERROR_E01,e.getMessage());
		} catch (IOException e) {
			throw new TestYException(TestYConstants.ERROR_E01,e.getMessage());
		} catch(NullPointerException e){
			throw new TestYException(TestYConstants.ERROR_E01,"parameter not found");
		}
		return userAsJson;
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public String register(@RequestBody Usuario usuario){
		String result="{\"result\":0}";
		try {
			usuarioService.insertUsuario(usuario);
			result="{\"result\":1}";
		} catch (TestYException e) {
			throw new TestYException(TestYConstants.ERROR_CLIENT_01,TestYConstants.ERROR_CLIENT_01_TEXT);
		}
		return result;
	}
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String hello(){
		return "Hello WOrld";
	}
}
