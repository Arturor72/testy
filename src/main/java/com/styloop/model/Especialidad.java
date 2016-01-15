package com.styloop.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Especialidad")
public class Especialidad {
	@Id
	@Column(name="esp_id")
	private Integer esp_id;
	@Column(name="esp_cod")
	private String esp_cod;
	@Column(name="esp_den")
	private String esp_den;
	
	@ManyToOne
	@JoinColumn(name="uni_id")

	private Universidad universidad;
	
	@OneToMany(mappedBy="especialidad")
	private List<Usuario> usuarios;
	
	@OneToMany(mappedBy="especialidad")
	private List<EspecialidadCurso> especialidadCurso;
	
	
	public Integer getEsp_id() {
		return esp_id;
	}
	public void setEsp_id(Integer esp_id) {
		this.esp_id = esp_id;
	}
	public String getEsp_cod() {
		return esp_cod;
	}
	public void setEsp_cod(String esp_cod) {
		this.esp_cod = esp_cod;
	}
	public String getEsp_den() {
		return esp_den;
	}
	public void setEsp_den(String esp_den) {
		this.esp_den = esp_den;
	}
	public Universidad getUniversidad() {
		return universidad;
	}
	public void setUniversidad(Universidad universidad) {
		this.universidad = universidad;
	}
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public List<EspecialidadCurso> getEspecialidadCurso() {
		return especialidadCurso;
	}
	public void setEspecialidadCurso(List<EspecialidadCurso> especialidadCurso) {
		this.especialidadCurso = especialidadCurso;
	}

	
}
