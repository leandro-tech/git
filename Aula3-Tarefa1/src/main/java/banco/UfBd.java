package banco;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.Uf;

public class UfBd implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("configDB");
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public void adicionar(Uf uf) {
		
		EntityManager em = getEntityManager();
		
		
		try {	
					
			em.getTransaction().begin();
			
			em.persist(uf);
		
			em.getTransaction().commit();
			
		} catch(Exception ex) {
			em.getTransaction().rollback();
			System.out.println(ex.toString());
			System.exit(0);
		}
		em.close();
		emf.close();
	}

	public Uf buscaPelaSigla(String siglaUf) {
		String jpql = "select u from Uf u where u.sigla = :sigla";
		EntityManager em = getEntityManager();
		TypedQuery<Uf> query = em.createQuery(jpql, Uf.class);
		query.setParameter("sigla", siglaUf);
		
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
}
