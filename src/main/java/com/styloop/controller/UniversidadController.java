package com.styloop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.styloop.common.TestYConstants;
import com.styloop.common.TestYException;
import com.styloop.common.util.TestYUtil;
import com.styloop.model.Universidad;
import com.styloop.service.UniversidadService;

@RestController
@RequestMapping(value="/universidad")
public class UniversidadController {

	@Autowired
	UniversidadService universidadService;
	@RequestMapping(value="/get", produces="application/json", consumes="application/json", method=RequestMethod.POST)
	public String getUniversidadById(@RequestBody String universidadAsString){
		String universidadAsJson="";
		ObjectMapper mapper=new ObjectMapper();
		try {
		JsonNode jnode=mapper.readTree(universidadAsString);	
		String universidadId=jnode.get("uni_id").asText();
		Universidad universidad=universidadService.getUniversidadById(Integer.parseInt(universidadId));
		universidadAsJson=TestYUtil.convertToJson(universidad);
		} catch (Exception e) {
		 throw new TestYException(TestYConstants.ERROR_E01, e.getMessage());
		}
		return universidadAsJson;
	}
	
}
