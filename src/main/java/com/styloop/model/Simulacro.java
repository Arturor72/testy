package com.styloop.model;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Simulacro")
public class Simulacro {
	@Id
	@Column(name="sim_id")
	private Integer sim_id;
	@Column(name="sim_cod")
	private String sim_cod;
	@Column(name="sim_fec")
	private Date sim_fec;
	@Column(name="sim_hor")
	private Time sim_hor;
	@Column(name="sim_est")
	private Integer sim_est;
	
	
	@ManyToOne
	@JoinColumn(name="usr_id")
	private Usuario usuario;
	
	@ManyToMany
	@JoinTable(name="SimulacroPregunta",
	joinColumns={@JoinColumn(name="sim_id", referencedColumnName="sim_id")},
	inverseJoinColumns={@JoinColumn(name="pre_id", referencedColumnName="pre_id")})
	private List<Pregunta> preguntas;

	public Integer getSim_id() {
		return sim_id;
	}

	public void setSim_id(Integer sim_id) {
		this.sim_id = sim_id;
	}

	public String getSim_cod() {
		return sim_cod;
	}

	public void setSim_cod(String sim_cod) {
		this.sim_cod = sim_cod;
	}

	public Date getSim_fec() {
		return sim_fec;
	}

	public void setSim_fec(Date sim_fec) {
		this.sim_fec = sim_fec;
	}

	public Time getSim_hor() {
		return sim_hor;
	}

	public void setSim_hor(Time sim_hor) {
		this.sim_hor = sim_hor;
	}

	public Integer getSim_est() {
		return sim_est;
	}

	public void setSim_est(Integer sim_est) {
		this.sim_est = sim_est;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}
	
	
}
