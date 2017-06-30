package br.com.marcelo.ControleCHProfessor.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Coordenacao_curso implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_coordenacao_curso")
	private int id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "ano")
	private int ano;
	@Column(name = "semestre")
	private Enum Semestre;
	@Column(name = "total_hora_semestre")
	private int totalHoraSemestre;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public Enum getSemestre() {
		return Semestre;
	}

	public void setSemestre(Enum semestre) {
		Semestre = semestre;
	}

	public int getTotalHoraSemestre() {
		return totalHoraSemestre;
	}

	public void setTotalHoraSemestre(int totalHoraSemestre) {
		this.totalHoraSemestre = totalHoraSemestre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
