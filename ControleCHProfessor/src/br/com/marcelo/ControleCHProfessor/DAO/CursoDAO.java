package br.com.marcelo.ControleCHProfessor.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import br.com.marcelo.ControleCHProfessor.modelo.Curso;
import br.com.marcelo.ControleCHProfessor.modelo.Faculdade;

public class CursoDAO {

	private static CursoDAO instance;
	protected EntityManager entityManager;

	public static CursoDAO getInstance() {
		if (instance == null) {
			instance = new CursoDAO();
		}

		return instance;
	}

	private CursoDAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("folhaPersistence");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}

	public Curso getById(final int id) {
		return entityManager.find(Curso.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Curso> findAll() {

		return entityManager.createQuery("FROM " + Curso.class.getName()).getResultList();

	}

	public void persist(Curso Curso) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(Curso);
			entityManager.getTransaction().commit();
			JOptionPane.showMessageDialog(null, "Salvo com sucesso");
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
			JOptionPane.showMessageDialog(null, "Erro ao Salvar");
		}
	}

	public void merge(Curso Curso) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(Curso);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(Curso Curso) {
		try {
			entityManager.getTransaction().begin();
			Curso = entityManager.find(Curso.class, Curso.getId());
			entityManager.remove(Curso);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void removeById(final int id) {
		try {
			Curso Curso = getById(id);
			remove(Curso);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
