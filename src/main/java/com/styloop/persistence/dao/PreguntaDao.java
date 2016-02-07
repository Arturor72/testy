package com.styloop.persistence.dao;

import java.util.List;

import com.styloop.model.Pregunta;

public interface PreguntaDao {
public List<Pregunta> getPreguntasByCursoId(Integer cursoId);
}
