package br.com.marcelo.ControleCHProfessor.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import br.com.marcelo.ControleCHProfessor.modelo.Disciplina;

public class DisciplinaDAO {

	
	private static DisciplinaDAO instance;
	protected EntityManager entityManager;

	public static DisciplinaDAO getInstance() {
		if (instance == null) {
			instance = new DisciplinaDAO();
		}

		return instance;
	}

	private DisciplinaDAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("folhaPersistence");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}

	public Disciplina getById(final int id) {
		return entityManager.find(Disciplina.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Disciplina> findAll() {
		
		return entityManager.createQuery("FROM " + Disciplina.class.getName()).getResultList();
		
	}

	public void persist(Disciplina Disciplina) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(Disciplina);
			entityManager.getTransaction().commit();
			JOptionPane.showMessageDialog(null, "Salvo com sucesso");
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
			JOptionPane.showMessageDialog(null, "Erro ao Salvar");
		}
	}

	public void merge(Disciplina Disciplina) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(Disciplina);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(Disciplina Disciplina) {
		try {
			entityManager.getTransaction().begin();
			Disciplina = entityManager.find(Disciplina.class, Disciplina.getId());
			entityManager.remove(Disciplina);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void removeById(final int id) {
		try {
			Disciplina Disciplina = getById(id);
			remove(Disciplina);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
