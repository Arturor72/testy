package com.styloop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.styloop.model.Especialidad;
import com.styloop.model.EspecialidadCurso;
import com.styloop.persistence.dao.EspecialidadCursoDao;
import com.styloop.persistence.dao.EspecialidadDao;

@Service
public class EspecialidadService {
	
	@Autowired
	EspecialidadDao especialidadDao;
	@Autowired
	EspecialidadCursoDao especialidadCursoDao;
	public Especialidad getEspecialidad(Integer id){
		
		List<Especialidad> listEspecialidades=especialidadDao.getEspecialidadById(id);
		Especialidad especialidad=null;
		if(listEspecialidades!=null&&!listEspecialidades.isEmpty()){
			especialidad=listEspecialidades.get(0);
		}
		return especialidad;
	}
	
	public List<EspecialidadCurso> getEspecialidadCurso(Integer espId){
		List<EspecialidadCurso> especialidadCurso=especialidadCursoDao.getEspecialidadCursoByEspecialidadId(espId);
		return especialidadCurso;
	}
	public List<Especialidad> getEspecialidadByUniversidadId(Integer uniId){
		List<Especialidad> especialidades=especialidadDao.getEspecialidadByUniversidadId(uniId);
		return especialidades;
	}

}
