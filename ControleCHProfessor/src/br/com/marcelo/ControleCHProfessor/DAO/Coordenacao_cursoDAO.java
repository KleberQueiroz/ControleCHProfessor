package br.com.marcelo.ControleCHProfessor.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import br.com.marcelo.ControleCHProfessor.modelo.Coordenacao_curso;

public class Coordenacao_cursoDAO {

	
	private static Coordenacao_cursoDAO instance;
	protected EntityManager entityManager;

	public static Coordenacao_cursoDAO getInstance() {
		if (instance == null) {
			instance = new Coordenacao_cursoDAO();
		}

		return instance;
	}

	private Coordenacao_cursoDAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("folhaPersistence");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}

	public Coordenacao_curso getById(final int id) {
		return entityManager.find(Coordenacao_curso.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Coordenacao_curso> findAll() {
		
		return entityManager.createQuery("FROM " + Coordenacao_curso.class.getName()).getResultList();
		
	}

	public void persist(Coordenacao_curso Coordenacao_curso) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(Coordenacao_curso);
			entityManager.getTransaction().commit();
			JOptionPane.showMessageDialog(null, "Salvo com sucesso");
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
			JOptionPane.showMessageDialog(null, "Erro ao Salvar");
		}
	}

	public void merge(Coordenacao_curso Coordenacao_curso) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(Coordenacao_curso);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(Coordenacao_curso Coordenacao_curso) {
		try {
			entityManager.getTransaction().begin();
			Coordenacao_curso = entityManager.find(Coordenacao_curso.class, Coordenacao_curso.getId());
			entityManager.remove(Coordenacao_curso);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void removeById(final int id) {
		try {
			Coordenacao_curso Coordenacao_curso = getById(id);
			remove(Coordenacao_curso);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
