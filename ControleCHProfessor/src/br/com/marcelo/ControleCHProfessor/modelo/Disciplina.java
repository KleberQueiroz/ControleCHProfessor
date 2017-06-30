package br.com.marcelo.ControleCHProfessor.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Disciplina implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column (name="id_disciplina")
	private int id;
	@Column (name="nome")
	private String nome;
	@Column (name="descricao")
	private String descricao;
	@Column (name="hora_mes")
	private int hora_mes;
	@Column (name="hora_semestre")
	private int hora_semestre;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getHora_mes() {
		return hora_mes;
	}
	public void setHora_mes(int hora_mes) {
		this.hora_mes = hora_mes;
	}
	public int getHora_semestre() {
		return hora_semestre;
	}
	public void setHora_semestre(int hora_semestre) {
		this.hora_semestre = hora_semestre;
	}
}
