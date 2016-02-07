package com.styloop.service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.styloop.model.Pregunta;
import com.styloop.persistence.dao.PreguntaDao;

@Service
public class PreguntaService {
	
	@Autowired
	PreguntaDao preguntaDao;
	
	public List<Pregunta> getPreguntas(Integer cursoId){
		List<Pregunta> preguntas=preguntaDao.getPreguntasByCursoId(cursoId);
		return preguntas;
	}
	public Set<Pregunta> getPreguntasRandom(List<Pregunta> prePreguntas, Integer cantidad){
		Set<Pregunta> preguntas=null;
		Random random=new Random();
		if(prePreguntas.size()<cantidad){
			preguntas=new HashSet<Pregunta>(prePreguntas);
		}else{
			preguntas=new HashSet<Pregunta>();
			while(preguntas.size()<cantidad){
				int indice=random.nextInt(prePreguntas.size());
				preguntas.add(prePreguntas.get(indice));
			}
		}
		return preguntas;
	}

}
