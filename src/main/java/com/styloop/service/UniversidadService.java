package com.styloop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.styloop.model.Universidad;
import com.styloop.persistence.dao.EspecialidadDao;
import com.styloop.persistence.dao.UniversidadDao;

@Service
public class UniversidadService {
	
	@Autowired 
	private UniversidadDao universidadDao;
	@Autowired
	private EspecialidadDao especialidadDao;
	
	public Universidad getUniversidadById(Integer id){
		List<Universidad> listUniversidades=universidadDao.getUniversidadById(id);
		Universidad universidad=null;
		if(listUniversidades!=null&&!listUniversidades.isEmpty()){
			universidad=listUniversidades.get(0);
			universidad.setEspecialidades(especialidadDao.getEspecialidadByUniversidadId(id));
		}
		return universidad;
	}

}
