package com.styloop.persistence.dao;

import java.util.List;

import com.styloop.model.Curso;

public interface CursoDao {
	public List<Curso> getCursoById(Integer id);
}
