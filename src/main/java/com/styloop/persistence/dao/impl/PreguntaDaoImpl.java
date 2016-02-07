package com.styloop.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.styloop.model.Pregunta;
import com.styloop.persistence.dao.PreguntaDao;

@Repository(value="preguntaDao")
public class PreguntaDaoImpl implements PreguntaDao{
	private EntityManager em;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em){
		this.em=em;
	}

	@Override
	@Transactional(readOnly=true)
	@SuppressWarnings("unchecked")
	public List<Pregunta> getPreguntasByCursoId(Integer cursoId) {
		String query="Select p from Pregunta p where p.tema.curso.cur_id=:id";
		Query prepareQuery=em.createQuery(query);
		prepareQuery.setParameter("id",cursoId);
		return prepareQuery.getResultList();
	}

}
