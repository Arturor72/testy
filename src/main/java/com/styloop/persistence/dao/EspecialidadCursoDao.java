package com.styloop.persistence.dao;

import java.util.List;

import com.styloop.model.EspecialidadCurso;

public interface EspecialidadCursoDao {
	public List<EspecialidadCurso> getEspecialidadCursoByEspecialidadId(Integer id);

}
