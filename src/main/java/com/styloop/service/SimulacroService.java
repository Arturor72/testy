package com.styloop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.styloop.common.TestYException;
import com.styloop.model.Simulacro;
import com.styloop.persistence.dao.SimulacroDao;

@Service
public class SimulacroService {
	
	@Autowired
	private SimulacroDao simulacroDao;
	
	public Simulacro getSimulacro(){
		Simulacro simulacro=null;
		
		return simulacro;
	}
	
	public void insertSimulacro(Simulacro simulacro) throws TestYException{
		simulacroDao.insertSimulacro(simulacro);
	}

}
