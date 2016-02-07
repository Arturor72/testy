package com.styloop.persistence.dao;

import java.util.List;

import com.styloop.model.Especialidad;

public interface EspecialidadDao {

	public List<Especialidad> getEspecialidadById(Integer id);
	public List<Especialidad> getEspecialidadByUniversidadId(Integer id);
}
