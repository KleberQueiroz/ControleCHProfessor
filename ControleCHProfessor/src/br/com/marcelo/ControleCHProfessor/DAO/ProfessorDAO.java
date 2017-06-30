package br.com.marcelo.ControleCHProfessor.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import br.com.marcelo.ControleCHProfessor.modelo.Professor;

public class ProfessorDAO {

	
	private static ProfessorDAO instance;
	protected EntityManager entityManager;

	public static ProfessorDAO getInstance() {
		if (instance == null) {
			instance = new ProfessorDAO();
		}

		return instance;
	}

	private ProfessorDAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("folhaPersistence");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}

	public Professor getById(final int id) {
		return entityManager.find(Professor.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Professor> findAll() {
		
		return entityManager.createQuery("FROM " + Professor.class.getName()).getResultList();
		
	}

	public void persist(Professor Professor) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(Professor);
			entityManager.getTransaction().commit();
			JOptionPane.showMessageDialog(null, "Salvo com sucesso");
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
			JOptionPane.showMessageDialog(null, "Erro ao Salvar");
		}
	}

	public void merge(Professor Professor) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(Professor);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(Professor Professor) {
		try {
			entityManager.getTransaction().begin();
			Professor= entityManager.find(Professor.class, Professor.getId());
			entityManager.remove(Professor);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void removeById(final int id) {
		try {
			Professor Professor= getById(id);
			remove(Professor);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
