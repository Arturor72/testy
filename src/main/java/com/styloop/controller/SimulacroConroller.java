package com.styloop.controller;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.styloop.common.TestYConstants;
import com.styloop.common.TestYException;
import com.styloop.common.util.TestYUtil;
import com.styloop.model.Curso;
import com.styloop.model.Especialidad;
import com.styloop.model.EspecialidadCurso;
import com.styloop.model.Pregunta;
import com.styloop.model.Simulacro;
import com.styloop.model.Usuario;
import com.styloop.service.CursoService;
import com.styloop.service.EspecialidadService;
import com.styloop.service.PreguntaService;
import com.styloop.service.SimulacroService;
import com.styloop.service.UsuarioService;

@RestController
@RequestMapping(value="/simulacro")
public class SimulacroConroller {
	@Autowired
	CursoService cursoService;
	
	@Autowired
	EspecialidadService especialidadService;
	
	@Autowired
	PreguntaService preguntaService;
	
	@Autowired
	SimulacroService simulacroService;
	
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping(value="/curso", consumes="application/json", produces="application/json")
	public String getCurso(@RequestBody String cursoRequesId) throws TestYException{
		String cursoAsJson;
		Curso curso;
		try {
			ObjectMapper mapper=new ObjectMapper();
			JsonNode jnode=mapper.readTree(cursoRequesId);
			String cursoId=jnode.get("cursoId").asText();
			Integer cursoIdAsInteger=Integer.parseInt(cursoId);
			curso=cursoService.getCursoById(cursoIdAsInteger);
			
			cursoAsJson=TestYUtil.convertToJson(curso);	
		} catch (Exception e) {
			throw new TestYException(TestYConstants.ERROR_E01, "Error Interno");
		}
		
		return cursoAsJson;
	}
	@RequestMapping(value="/simulacro", consumes="application/json", produces="application/json")
	public String getSimulacro(@RequestBody Usuario usuario) throws TestYException{
		String simulacroAsJson="";
		usuario=getUsuario(usuario);
		Integer especialidadId=usuario.getEspecialidad().getEsp_id();
		Especialidad especialidad=especialidadService.getEspecialidad(especialidadId);
		Set<Pregunta> setTotalPreguntas=generatePreguntas(especialidad);
		List<Pregunta> preguntas=new ArrayList<Pregunta>(setTotalPreguntas);
		Simulacro simulacro=crowdSimulacro(preguntas, usuario);
		simulacroService.insertSimulacro(simulacro);
		simulacroAsJson=converSimulacro(simulacro);
		return simulacroAsJson;
	}
	private Set<Pregunta> generatePreguntas(Especialidad especialidad){
		List<EspecialidadCurso> listEspecialidadCurso=especialidadService.getEspecialidadCurso(especialidad.getEsp_id());
		Set<Pregunta> setTotalPreguntas=new HashSet<Pregunta>();
		Set<Pregunta> setPreguntas=null;
		for (EspecialidadCurso especialidadCurso : listEspecialidadCurso) {
			List<Pregunta> listPreguntas=preguntaService.getPreguntas(especialidadCurso.getCurso().getCur_id());
			setPreguntas=preguntaService.getPreguntasRandom(listPreguntas, especialidadCurso .getCantidad());
			if(setPreguntas.size()>0&&!setPreguntas.isEmpty()){
				setTotalPreguntas.addAll(setPreguntas);
			}
		}
	return setTotalPreguntas;
	}
	private Simulacro crowdSimulacro(List<Pregunta> preguntas, Usuario usuario){
		Simulacro simulacro=new Simulacro();
		simulacro.setPreguntas(preguntas);
		simulacro.setSim_est(TestYConstants.SIMULACRO_STATE_INIT);
		Date date=new Date();
		java.sql.Date datesql=new java.sql.Date(date.getTime());
		simulacro.setSim_fec(datesql);
		simulacro.setSim_hor(new Time(date.getTime()));
		simulacro.setSim_hor(new Time(date.getTime()));
		simulacro.setUsuario(usuario);
		simulacro.setSim_cod("SIM_01");
		return simulacro;
	}
	
	private String converSimulacro(Simulacro simulacro) throws TestYException{
		String simulacroAsJson="";
		try {
			simulacroAsJson=TestYUtil.convertToJson(simulacro);
		} catch (JsonProcessingException e) {
			throw new TestYException(TestYConstants.ERROR_E01, e.getMessage());
		} 
		return simulacroAsJson;
	}
	private Usuario getUsuario(Usuario usuario){
		return usuarioService.getUsuarioByUserAndPassword(usuario.getUsr_usr(),usuario.getUsr_pas());
	}
	
}
