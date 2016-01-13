package com.styloop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="usr_id")
	private Integer usr_id;
	@Column(name="usr_nom")
	private String usr_nom;
	@Column(name="usr_app")
	private String usr_app;
	@Column(name="usr_apm")
	private String usr_apm;
	@Column(name="usr_ema")
	private String usr_ema;
	@Column(name="usr_usr")
	private String usr_usr;
	@Column(name="usr_pas")
	private String usr_pas;
	@Column(name="usr_cel")
	private String usr_cel;
	@Column(name="usr_upd")
	private String usr_upd;
	@Column(name="usr_est")
	private String usr_est;
	@ManyToOne
	@JoinColumn(name = "esp_id")
	private Especialidad especialidad;
	
	public Especialidad getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}
	public Integer getUsr_id() {
		return usr_id;
	}
	public void setUsr_id(Integer usr_id) {
		this.usr_id = usr_id;
	}
	public String getUsr_nom() {
		return usr_nom;
	}
	public void setUsr_nom(String usr_nom) {
		this.usr_nom = usr_nom;
	}
	public void setUsr_pas(String usr_pas) {
		this.usr_pas = usr_pas;
	}
	public String getUsr_app() {
		return usr_app;
	}
	public void setUsr_app(String usr_app) {
		this.usr_app = usr_app;
	}
	public String getUsr_apm() {
		return usr_apm;
	}
	public void setUsr_apm(String usr_apm) {
		this.usr_apm = usr_apm;
	}
	public String getUsr_ema() {
		return usr_ema;
	}
	public void setUsr_ema(String usr_ema) {
		this.usr_ema = usr_ema;
	}
	public String getUsr_usr() {
		return usr_usr;
	}
	public void setUsr_usr(String usr_usr) {
		this.usr_usr = usr_usr;
	}
	public String getUsr_pas() {
		return usr_pas;
	}
	public void setUsr_pass(String usr_pas) {
		this.usr_pas = usr_pas;
	}
	public String getUsr_cel() {
		return usr_cel;
	}
	public void setUsr_cel(String usr_cel) {
		this.usr_cel = usr_cel;
	}
	public String getUsr_upd() {
		return usr_upd;
	}
	public void setUsr_upd(String usr_upd) {
		this.usr_upd = usr_upd;
	}
	public String getUsr_est() {
		return usr_est;
	}
	public void setUsr_est(String usr_est) {
		this.usr_est = usr_est;
	}
	
	
}
