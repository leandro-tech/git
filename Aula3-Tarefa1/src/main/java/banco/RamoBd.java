package banco;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.Ramo;

public class RamoBd implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("configDB");
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public void adicionar(Ramo ramo) {
		
		EntityManager em = getEntityManager();
		
		
		try {	
			//System.out.println(ramo.getNome());
		
			em.getTransaction().begin();
			
			em.persist(ramo);
		
			em.getTransaction().commit();
			
		} catch(Exception ex) {
			em.getTransaction().rollback();
			System.out.println(ex.toString());
			System.exit(0);
		}
		em.close();
		emf.close();
	}

	public Ramo buscaPeloRamo(String nomeRamo) {
		String jpql = "select u from Ramo u where u.nome = :nome";
		EntityManager em = getEntityManager();
		TypedQuery<Ramo> query = em.createQuery(jpql, Ramo.class);
		query.setParameter("nome", nomeRamo);
		
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
}
