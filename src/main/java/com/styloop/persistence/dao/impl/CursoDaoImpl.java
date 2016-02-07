package com.styloop.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.styloop.model.Curso;
import com.styloop.persistence.dao.CursoDao;

@Repository(value="cursoDao")
public class CursoDaoImpl implements CursoDao {
	
	EntityManager em;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em){
		this.em=em;
	}

	@Override
	@Transactional(readOnly=true)
	@SuppressWarnings("unchecked")
	public List<Curso> getCursoById(Integer id) {
		String query="Select c from Curso c where c.cur_id= :id";
		Query prepareQuery=em.createQuery(query);
		prepareQuery.setParameter("id", id);
		return prepareQuery.getResultList();
	}
	
}
