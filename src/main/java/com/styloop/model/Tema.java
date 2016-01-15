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
@Table(name="Tema")
public class Tema {
	@Id
	@Column(name="tem_id")
	private Integer tem_id;
	@Column(name="tem_cod")
	private String tem_cod;
	@Column(name="tem_des")
	private String tem_des;
	@ManyToOne
	@JoinColumn(name="cur_id")
	private Curso curso;
	
	@OneToMany(mappedBy="tema")
	private List<Pregunta> preguntas;
	
	
	public Integer getTem_id() {
		return tem_id;
	}
	public void setTem_id(Integer tem_id) {
		this.tem_id = tem_id;
	}
	public String getTem_cod() {
		return tem_cod;
	}
	public void setTem_cod(String tem_cod) {
		this.tem_cod = tem_cod;
	}
	public String getTem_des() {
		return tem_des;
	}
	public void setTem_des(String tem_des) {
		this.tem_des = tem_des;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public List<Pregunta> getPreguntas() {
		return preguntas;
	}
	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}
	
	
	
}
