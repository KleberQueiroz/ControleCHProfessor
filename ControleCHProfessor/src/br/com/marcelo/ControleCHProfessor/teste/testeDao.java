package br.com.marcelo.ControleCHProfessor.teste;

import br.com.marcelo.ControleCHProfessor.modelo.Faculdade;

public class testeDao {

	public static void main(String[] args) {
	
		Faculdade g =new Faculdade();
		g.setNome("Anhembi Morumbi");
		g.setCampus("Vila ");
		
		//FaculdadeDAO.getInstance().findAll();
		
		
		System.out.println("Operação realizada com sucesso");
	}

}
