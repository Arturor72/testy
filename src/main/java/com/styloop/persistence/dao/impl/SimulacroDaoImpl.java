package com.styloop.persistence.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.styloop.common.TestYConstants;
import com.styloop.common.TestYException;
import com.styloop.model.Simulacro;
import com.styloop.persistence.dao.SimulacroDao;

@Repository(value="simulacroDao")
public class SimulacroDaoImpl implements SimulacroDao{
	private EntityManager em;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em){
		this.em=em;
	}
	
	@Override
	@Transactional
	public void insertSimulacro(Simulacro simulacro) throws TestYException{
		try {
			em.persist(simulacro);	
		} catch (Exception e) {
			throw new TestYException(TestYConstants.ERROR_E01, e.getMessage());
		}
	}
}
