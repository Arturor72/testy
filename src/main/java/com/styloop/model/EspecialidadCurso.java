package com.styloop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="EspecialidadCurso")
public class EspecialidadCurso {

	
	@ManyToOne
	@JoinColumn(name="esp_id")
	private Especialidad especialidad;
	@ManyToOne
	@JoinColumn(name="cur_id")
	private Curso curso;
	@Column(name="cantidad")
	private Integer cantidad;
	public Especialidad getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
}
