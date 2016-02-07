package com.styloop.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.styloop.model.Universidad;
import com.styloop.persistence.dao.UniversidadDao;

@Repository(value="universidadDao")
public class UniversidadDaoImpl implements UniversidadDao{
	
	public EntityManager em;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em){
		this.em=em;
	}
	
	@Override
	@Transactional(readOnly=false)
	@SuppressWarnings("unchecked")
	public List<Universidad> getUniversidadById(Integer id) {
		String query="Select u from Universidad u where u.uni_id=:id";
		Query prepareQuery=em.createQuery(query);
		prepareQuery.setParameter("id", id);
		return prepareQuery.getResultList();
	}

}
