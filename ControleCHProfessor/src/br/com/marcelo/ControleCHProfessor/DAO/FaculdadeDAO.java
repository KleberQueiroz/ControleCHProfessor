package br.com.marcelo.ControleCHProfessor.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import br.com.marcelo.ControleCHProfessor.modelo.Faculdade;

public class FaculdadeDAO {

	
	private static FaculdadeDAO instance;
	protected EntityManager entityManager;

	public static FaculdadeDAO getInstance() {
		if (instance == null) {
			instance = new FaculdadeDAO();
		}

		return instance;
	}

	private FaculdadeDAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("folhaPersistence");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}

	public Faculdade getById(final int id) {
		return entityManager.find(Faculdade.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Faculdade> findAll() {
		
		return entityManager.createQuery("FROM " + Faculdade.class.getName()).getResultList();
		
	}

	public void persist(Faculdade Faculdade) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(Faculdade);
			entityManager.getTransaction().commit();
			JOptionPane.showMessageDialog(null, "Salvo com sucesso");
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
			JOptionPane.showMessageDialog(null, "Erro ao Salvar");
		}
	}

	public void merge(Faculdade Faculdade) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(Faculdade);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(Faculdade Faculdade) {
		try {
			entityManager.getTransaction().begin();
			Faculdade = entityManager.find(Faculdade.class, Faculdade.getId());
			entityManager.remove(Faculdade);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void removeById(final int id) {
		try {
			Faculdade Faculdade = getById(id);
			remove(Faculdade);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
