package br.com.marcelo.ControleCHProfessor.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import br.com.marcelo.ControleCHProfessor.modelo.Coodenacao_instituto;


public class Coordenacao_institutoDAO {

	
	private static Coordenacao_institutoDAO instance;
	protected EntityManager entityManager;

	public static Coordenacao_institutoDAO getInstance() {
		if (instance == null) {
			instance = new Coordenacao_institutoDAO();
		}

		return instance;
	}

	private Coordenacao_institutoDAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("folhaPersistence");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}

	public Coodenacao_instituto getById(final int id) {
		return entityManager.find(Coodenacao_instituto.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Coodenacao_instituto> findAll() {
		
		return entityManager.createQuery("FROM " + Coodenacao_instituto.class.getName()).getResultList();
		
	}

	public void persist(Coodenacao_instituto Coordenacao_instituto) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(Coordenacao_instituto);
			entityManager.getTransaction().commit();
			JOptionPane.showMessageDialog(null, "Salvo com sucesso");
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
			JOptionPane.showMessageDialog(null, "Erro ao Salvar");
		}
	}

	public void merge(Coodenacao_instituto Coordenacao_instituto) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(Coordenacao_instituto);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(Coodenacao_instituto Coordenacao_instituto) {
		try {
			entityManager.getTransaction().begin();
			Coordenacao_instituto = entityManager.find(Coodenacao_instituto.class, Coordenacao_instituto.getId());
			entityManager.remove(Coordenacao_instituto);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void removeById(final int id) {
		try {
			Coodenacao_instituto Coordenacao_instituto = getById(id);
			remove(Coordenacao_instituto);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
