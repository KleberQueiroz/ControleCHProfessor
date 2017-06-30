package br.com.marcelo.ControleCHProfessor.util;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class FaculdadeTableModel extends AbstractTableModel{
	// Lista de Sócios a serem exibidos na tabela
	private ArrayList linhas=null;
	private String []colunas=null;

		public FaculdadeTableModel(ArrayList lin, String[] col) {
			setLinhas(lin);
			setColunas(col);
			
		}
	public ArrayList getLinhas() {
		return linhas;
	}


	public void setLinhas(ArrayList dados) {
		this.linhas = dados;
	}


	public String[] getColunas() {
		return colunas;
	}


	public void setColunas(String[] nomes) {
		this.colunas = nomes;
	}
	@Override
	public int getColumnCount() {
		return colunas.length;
	}
	@Override
	public int getRowCount() {
		return linhas.size();
	}
	@Override
	public String getColumnName(int columnIndex) {
		return colunas[columnIndex];
	};
	
	public Object getValueAt(int numLin, int numCol) {

		Object []linha = (Object[])getLinhas().get(numLin);
		return linha [numCol];
	}
	// Cria um SocioTableModel sem nenhuma linha






}
