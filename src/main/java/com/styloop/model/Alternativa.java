package com.styloop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Alternativa")
public class Alternativa {
	@Id
	@Column(name="alt_id")
	private Integer alt_id;
	@Column(name="alt_cod")
	private String alt_cod;
	@Column(name="alt_des")
	private String alt_des;
	
	@ManyToOne
	@JoinColumn(name="pre_id")
	private Pregunta pregunta;

	public Integer getAlt_id() {
		return alt_id;
	}

	public void setAlt_id(Integer alt_id) {
		this.alt_id = alt_id;
	}

	public String getAlt_cod() {
		return alt_cod;
	}

	public void setAlt_cod(String alt_cod) {
		this.alt_cod = alt_cod;
	}

	public String getAlt_des() {
		return alt_des;
	}

	public void setAlt_des(String alt_des) {
		this.alt_des = alt_des;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}
	
	
}
