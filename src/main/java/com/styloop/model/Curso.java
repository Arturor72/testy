package com.styloop.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="curso")
public class Curso {
		@Id
		private Integer cur_id;
		@Column(name="cur_cod")
		private String cur_cod;
		@Column(name="cur_des")
		private String cur_des;
		
		@OneToMany(mappedBy="curso")
		private List<Tema> temas;
		
		@OneToMany(mappedBy="curso")
		private List<EspecialidadCurso> especialidadCurso;

		public Integer getCur_id() {
			return cur_id;
		}

		public void setCur_id(Integer cur_id) {
			this.cur_id = cur_id;
		}

		public String getCur_cod() {
			return cur_cod;
		}

		public void setCur_cod(String cur_cod) {
			this.cur_cod = cur_cod;
		}

		public String getCur_des() {
			return cur_des;
		}

		public void setCur_des(String cur_des) {
			this.cur_des = cur_des;
		}

		public List<Tema> getTemas() {
			return temas;
		}

		public void setTemas(List<Tema> temas) {
			this.temas = temas;
		}

		public List<EspecialidadCurso> getEspecialidadCurso() {
			return especialidadCurso;
		}

		public void setEspecialidadCurso(List<EspecialidadCurso> especialidadCurso) {
			this.especialidadCurso = especialidadCurso;
		}
		
		
	
}
