package com.styloop.persistence.dao;

import java.util.List;

import com.styloop.model.Universidad;

public interface UniversidadDao {

	public List<Universidad> getUniversidadById(Integer id);
}
