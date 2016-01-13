package com.styloop.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Universidad")
public class Universidad {
	@Id
	@Column(name="uni_id")
	private Integer uni_id;
	@Column(name="uni_cod")
	private String uni_cod;
	@Column(name="uni_den")
	private String uni_den;
	
	@OneToMany(mappedBy="universidad",fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Especialidad> especialidades;
	
	public Integer getUni_id() {
		return uni_id;
	}
	public void setUni_id(Integer uni_id) {
		this.uni_id = uni_id;
	}
	public String getUni_cod() {
		return uni_cod;
	}
	public void setUni_cod(String uni_cod) {
		this.uni_cod = uni_cod;
	}
	public String getUni_den() {
		return uni_den;
	}
	public void setUni_den(String uni_den) {
		this.uni_den = uni_den;
	}
	public List<Especialidad> getEspecialidades() {
		return especialidades;
	}
	public void setEspecialidades(List<Especialidad> especialidades) {
		this.especialidades = especialidades;
	}
	
	
	
}
