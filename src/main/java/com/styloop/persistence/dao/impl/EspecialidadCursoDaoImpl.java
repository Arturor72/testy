package com.styloop.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.styloop.model.EspecialidadCurso;
import com.styloop.persistence.dao.EspecialidadCursoDao;

@Repository(value="especialidadCursoDao")
public class EspecialidadCursoDaoImpl implements EspecialidadCursoDao{

	EntityManager em;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em){
		this.em=em;	
	}
	@Override
	@Transactional(readOnly=true)
	@SuppressWarnings("unchecked")
	public List<EspecialidadCurso> getEspecialidadCursoByEspecialidadId(Integer id) {
		String query="Select ec from EspecialidadCurso ec where ec.especialidad.esp_id=:id";
		Query prepareQuery=em.createQuery(query);
		prepareQuery.setParameter("id", id);
		return prepareQuery.getResultList();
	}
}
