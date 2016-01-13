package com.styloop.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.styloop.model.Usuario;
import com.styloop.persistence.dao.UsuarioDao;

@Repository(value="usuarioDao")
public class UsuarioDaoImpl implements UsuarioDao {
	private EntityManager em;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em){
		this.em=em;
	}
	
	@Override
	@Transactional(readOnly=true)
	@SuppressWarnings("unchecked")
	public List<Usuario> getUser(Integer id) {
		String query="Select u from Usuario u where u.usr_id= :id";
		Query prepareQuery=em.createQuery(query);
		prepareQuery.setParameter("id", id);
		return prepareQuery.getResultList();
	}
	@Override
	@Transactional(readOnly=true)
	@SuppressWarnings("unchecked")
	public List<Usuario> getUserByUserAndPassword(String user, String password) {
		String query="Select u from Usuario u where u.usr_usr=:user and u.usr_pas= :pas";
		Query prepareQuery=em.createQuery(query);
		prepareQuery.setParameter("user", user);
		prepareQuery.setParameter("pas", password);
		return prepareQuery.getResultList();
	}
	
	@Override
	@Transactional
	public void registerUser(Usuario usuario) throws Exception{
		em.persist(usuario);
	}
}
