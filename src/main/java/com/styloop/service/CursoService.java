package com.styloop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.styloop.model.Curso;
import com.styloop.persistence.dao.CursoDao;

@Service
public class CursoService {
	
	@Autowired
	CursoDao cursoDao;
	
	public Curso getCursoById(Integer id){
		List<Curso> cursos=cursoDao.getCursoById(id);
		Curso curso=null;
		if(cursos!=null&&!cursos.isEmpty()){
			curso=cursos.get(0);
		}
		return curso;
	}
	

}
