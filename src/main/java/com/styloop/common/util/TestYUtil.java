package com.styloop.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

public class TestYUtil {

	public static String convertToJson(Object object) throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new Hibernate4Module());
		return mapper.writeValueAsString(object);
	}
}
