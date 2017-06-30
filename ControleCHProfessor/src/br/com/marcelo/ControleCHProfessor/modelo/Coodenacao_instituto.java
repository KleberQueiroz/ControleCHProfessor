package br.com.marcelo.ControleCHProfessor.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Coodenacao_instituto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_coordenacao_instituto")
	private int id;
	@Column ( name= "nome")
	private String nome;
	@Column(name = "total_hora_semestre")
	private int total_hora_semestre;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTotal_hora_semestre() {
		return total_hora_semestre;
	}

	public void setTotal_hora_semestre(int total_hora_semestre) {
		this.total_hora_semestre = total_hora_semestre;
	}

}
