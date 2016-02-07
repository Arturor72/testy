package com.styloop.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.styloop.model.Especialidad;
import com.styloop.persistence.dao.EspecialidadDao;

@Repository(value="especialidadDao")
public class EspecialidadDaoImpl implements EspecialidadDao{
	
	EntityManager em;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em){
		this.em=em;
	}
	
	@Override
	@Transactional(readOnly=true)
	@SuppressWarnings("unchecked")
	public List<Especialidad> getEspecialidadById(Integer id) {
		String query="Select e from Especialidad e where e.esp_id= :id";
		Query prepareQuery=em.createQuery(query);
		prepareQuery.setParameter("id", id);
		return prepareQuery.getResultList();
	}
	
	@Override
	@Transactional(readOnly=true)
	@SuppressWarnings("unchecked")
	public List<Especialidad> getEspecialidadByUniversidadId(Integer id) {
		String query="Select e from Especialidad e where e.universidad.uni_id=:id";
		Query prepareQuery=em.createQuery(query);
		prepareQuery.setParameter("id", id);
		return prepareQuery.getResultList();
	}

}
