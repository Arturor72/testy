package com.styloop.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Pregunta")
public class Pregunta {
	@Id
	@Column(name="pre_id")
	private Integer pre_id;
	@Column(name="pre_cod")
	private String pre_cod;
	@Column(name="pre_des")
	private String pre_des;
	@Column(name="pre_res")
	private String pre_res;
	@ManyToOne
	@JoinColumn(name="tem_id")
	private Tema tema;
	
	@OneToMany(mappedBy="pregunta") 
	private List<Alternativa> alternativas;
	
	@ManyToMany
	@JoinTable(name="SimulacroPregunta",
	joinColumns={@JoinColumn(name="pre_id", referencedColumnName="pre_id")},
	inverseJoinColumns={@JoinColumn(name="sim_id", referencedColumnName="sim_id")})
	private List<Simulacro> simulacros;

	public Integer getPre_id() {
		return pre_id;
	}

	public void setPre_id(Integer pre_id) {
		this.pre_id = pre_id;
	}

	public String getPre_cod() {
		return pre_cod;
	}

	public void setPre_cod(String pre_cod) {
		this.pre_cod = pre_cod;
	}

	public String getPre_des() {
		return pre_des;
	}

	public void setPre_des(String pre_des) {
		this.pre_des = pre_des;
	}

	public String getPre_res() {
		return pre_res;
	}

	public void setPre_res(String pre_res) {
		this.pre_res = pre_res;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public List<Alternativa> getAlternativas() {
		return alternativas;
	}

	public void setAlternativas(List<Alternativa> alternativas) {
		this.alternativas = alternativas;
	}

	public List<Simulacro> getSimulacros() {
		return simulacros;
	}

	public void setSimulacros(List<Simulacro> simulacros) {
		this.simulacros = simulacros;
	}
	
	
}
